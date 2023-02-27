package touristTrip.service;

import touristTrip.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
