package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import touristTrip.entity.TripDate;

@Repository
public interface TripDateRepository extends JpaRepository<TripDate,Long> {


}
