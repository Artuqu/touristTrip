package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import touristTrip.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);
}
