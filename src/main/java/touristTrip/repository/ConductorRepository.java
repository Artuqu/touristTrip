package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor,Long> {


}
