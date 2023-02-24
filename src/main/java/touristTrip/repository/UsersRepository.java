package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import touristTrip.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);
}
