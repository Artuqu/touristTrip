package touristTrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristTrip.entity.Conductor;
import touristTrip.entity.Customer;
import touristTrip.entity.Trip;
import touristTrip.entity.TripDate;
import touristTrip.repository.ConductorRepository;
import touristTrip.repository.CustomerRepository;
import touristTrip.repository.TripDateRepository;
import touristTrip.repository.TripRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaTouristService implements TouristService {

    ConductorRepository conductorRepository;
    CustomerRepository customerRepository;
    TripDateRepository tripDateRepository;
    TripRepository tripRepository;

    @Autowired
    JpaTouristService(ConductorRepository conductorRepository, CustomerRepository customerRepository,
                      TripDateRepository tripDateRepository, TripRepository tripRepository) {
        this.conductorRepository = conductorRepository;
        this.customerRepository = customerRepository;
        this.tripDateRepository = tripDateRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerList(Long customerId) {
        return customerRepository.findById(customerId);
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
    public Optional<Trip> findTripList(Long tripId) {
        return tripRepository.findById(tripId);
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
}
