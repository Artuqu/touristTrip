package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Customer;
import touristTrip.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {


}
