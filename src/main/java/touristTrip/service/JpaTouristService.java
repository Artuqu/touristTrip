package touristTrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristTrip.entity.*;
import touristTrip.repository.*;

import java.util.List;

@Service
public class JpaTouristService implements TouristService {

    ConductorRepository conductorRepository;
    CustomerRepository customerRepository;
    TripDateRepository tripDateRepository;
    TripRepository tripRepository;

    CustomerTripsRepository customerTripsRepository;

    @Autowired
    JpaTouristService(ConductorRepository conductorRepository, CustomerRepository customerRepository,
                      TripDateRepository tripDateRepository, TripRepository tripRepository, CustomerTripsRepository customerTripsRepository) {
        this.conductorRepository = conductorRepository;
        this.customerRepository = customerRepository;
        this.tripDateRepository = tripDateRepository;
        this.tripRepository = tripRepository;
        this.customerTripsRepository = customerTripsRepository;
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor findConductor(Long id) {
        return conductorRepository.getOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Customer findCustomer(Long customerId) {
        return customerRepository.getOne(customerId);
    }


    @Override
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public CustomerTrips save(CustomerTrips customerTrips) {
        return customerTripsRepository.save(customerTrips);
    }


    @Override
    public Trip findTrip(Long tripId) {
        return tripRepository.getOne(tripId);
    }

    @Override
    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<TripDate> findAllDates() {
        return tripDateRepository.findAll();
    }

    @Override
    public List<Conductor> findAllConductors() {
        return conductorRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<TripDate> getAllStartDates(Long tripId) {
        return tripDateRepository.findAllTripDatesByTripId(tripId);
    }

    @Override
    public TripDate findTripStartDate(Long id) {
        return tripDateRepository.getOne(id);
    }

    @Override
    public Object getMostWanted() {
        return tripRepository.mostWanted();
    }

    @Override
    public List<Customer> customersWithoutTrip() {
        return customerRepository.customersWithoutTrip();
    }


}
