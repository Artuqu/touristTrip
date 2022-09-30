package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    @Query(value = "Select destination from Trip t INNER JOIN customerTrips ct on ct.trip=t.id group by t.id order by count(t.id) desc limit 1")
    Object mostWanted();


}
