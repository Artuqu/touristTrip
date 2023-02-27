package touristTrip.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import touristTrip.entity.Role;
import touristTrip.entity.User;
import touristTrip.repository.RoleRepository;
import touristTrip.repository.UserRepository;

import java.util.Collections;
import java.util.HashSet;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }



    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
        userRepository.save(user);
    }
}
