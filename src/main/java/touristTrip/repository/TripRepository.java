package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Trip;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    @Query(value = "Select count(max(t.id)), destination from Trip t INNER JOIN customerTrips ct on ct.trip=t.id")
    List<Trip> mostWanted();


}
