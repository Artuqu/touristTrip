package touristTrip.repository;

import jdk.jfr.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Customer;
import touristTrip.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    @Query(value = "Select max(Trip.Id) from Trip inner join Customer_Trips on Customer_Trips.Trip_Id=Trip.Id", nativeQuery = true)
    Object mostWanted();

//    @Query(value = "")

}
