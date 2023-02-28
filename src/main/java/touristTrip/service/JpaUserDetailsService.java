package touristTrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import touristTrip.entity.User;
import touristTrip.repository.RoleRepository;
import touristTrip.repository.UserRepository;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {


    final private UserRepository userRepository;
    final private RoleRepository roleRepository;

    @Autowired
    public JpaUserDetailsService(UserRepository userRepository, RoleRepository role) {
        this.userRepository = userRepository;
        this.roleRepository = role;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Username " + username + " does not exist!");
        }
        return optionalUser.get();
    }
}
