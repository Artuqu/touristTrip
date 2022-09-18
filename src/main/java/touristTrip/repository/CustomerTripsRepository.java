package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import touristTrip.entity.CustomerTrips;

@Repository
public interface CustomerTripsRepository extends JpaRepository<CustomerTrips,Long> {


}
