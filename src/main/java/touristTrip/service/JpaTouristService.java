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
    public Customer findCustomer(Long customerId) {
        return customerRepository.getOne(customerId);
    }


    @Override
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
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
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
