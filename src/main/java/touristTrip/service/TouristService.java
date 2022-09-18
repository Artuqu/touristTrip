package touristTrip.service;

import touristTrip.entity.*;
import touristTrip.object.Trips;

import java.util.List;
import java.util.Optional;

public interface TouristService {

    Conductor save(Conductor conductor);

    Conductor findConductor(Long id);

    Customer save(Customer customer);


    Customer findCustomer(Long customerId);

    Trip save(Trip trip);

    CustomerTrips save(CustomerTrips customerTrips);


    Trip findTrip(Long tripId);

    List<Trip> findAllTrips();


    List<Customer> findAllCustomers();

    List<TripDate> findAllDates();

    List<Conductor> findAllConductors();

    void deleteCustomer(Long customerId);

    List<TripDate> getAllStartDates(Long tripId);

    TripDate findTripStartDate(Long id);

    Object getMostWanted();

    List<Customer> customersWithoutTrip();

    void deleteAllCustomerTrips(Long customerId);

    List<Trips> avgPriceList();


}
