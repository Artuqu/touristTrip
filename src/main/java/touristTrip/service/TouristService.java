package touristTrip.service;

import touristTrip.entity.Conductor;
import touristTrip.entity.Customer;
import touristTrip.entity.Trip;
import touristTrip.entity.TripDate;

import java.util.List;

public interface TouristService {

    Conductor save (Conductor conductor);
    Customer save (Customer customer);
    Customer findCustomer (Long customerId);
    Trip save (Trip trip);
    Trip findTrip(Long tripId);
    List<Trip> findAllTrips();

    List<Customer> findAllCustomers();

    List<TripDate> findAllDates();
    List<Conductor> findAllConductors();

    void deleteCustomer (Long customerId);

    List <TripDate> getAllStartDates(Long tripId);
}
