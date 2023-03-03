package touristTrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import touristTrip.entity.Role;
import touristTrip.entity.User;
import touristTrip.repository.RoleRepository;
import touristTrip.repository.UserRepository;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService, UserService {


    final private UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    final private PasswordEncoder passwordEncoder;

    @Autowired
    public JpaUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Username " + username + " does not exist!");
        }
        return optionalUser.get();
    }

    @Override
    public User saveUser(User user) {
        Assert.isNull(user.getId(), user + " is already in use");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> roleOptional = roleRepository.findByName("ADMIN");
        if (roleOptional.isPresent()) {
            user.getRoles().add(roleOptional.get());
        }
        return userRepository.save(user);
    }
}
