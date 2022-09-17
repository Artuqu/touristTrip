package touristTrip.repository;

import jdk.jfr.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Customer;
import touristTrip.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    @Query(value = "SELECT sum(customer_id) FROM trip where sum=max", nativeQuery = true)
    Integer mostWanted();
}
