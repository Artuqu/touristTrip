package touristTrip.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import touristTrip.service.JpaUserDetailsService;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {


    JpaUserDetailsService jpaUserDetailsService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityAuthenticationProvider(JpaUserDetailsService jpaUserDetailsService, PasswordEncoder passwordEncoder) {
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();

        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(credentials, "Password cannot be null");

        if (!(credentials instanceof String)) {
            return null;
        }
        String providedPassword = credentials.toString();
        UserDetails loadedUserDetails = jpaUserDetailsService.loadUserByUsername(name);
        String realPassword = loadedUserDetails.getPassword();
        if (!passwordEncoder.matches(providedPassword, realPassword)) {
            throw new BadCredentialsException("Wrong password");
        }

        return new UsernamePasswordAuthenticationToken(name, providedPassword, loadedUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
