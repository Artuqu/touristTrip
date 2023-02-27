package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import touristTrip.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
