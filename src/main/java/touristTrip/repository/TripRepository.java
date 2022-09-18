package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Trip;
import touristTrip.object.Trips;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    @Query(value = "Select destination from Trip inner join Customer_Trips on Customer_Trips.Trip_Id=Trip.Id", nativeQuery = true)
    Object mostWanted();

    @Query(value = "select (trip.id, trip.destination, avg(customer_trips.price)) " +
            "from trip right join customer_trips on " +
            "customer_trips.trip_id=trip.id group by trip.id;", nativeQuery = true)
    List<Trips> avgPrices();


}
