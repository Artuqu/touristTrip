package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import touristTrip.entity.CustomerTrips;

import java.util.List;

@Repository
public interface CustomerTripsRepository extends JpaRepository<CustomerTrips,Long> {



    @Query(value = "delete from customer_trips where customer_id LIKE :id", nativeQuery = true)
    List<CustomerTrips> deleteAllCustomerTripsByCustomerId(@Param("id")Long id);

}
