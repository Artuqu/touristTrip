package touristTrip.service;

import touristTrip.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findUserByName(String username);
}
