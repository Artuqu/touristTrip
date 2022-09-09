package touristTrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristTrip.entity.Conductor;
import touristTrip.entity.Customer;
import touristTrip.entity.SuggestedPrice;
import touristTrip.entity.Trip;
import touristTrip.repository.ConductorRepository;
import touristTrip.repository.CustomerRepository;
import touristTrip.repository.SuggestedPriceRepository;
import touristTrip.repository.TripRepository;

@Service
public class JpaTouristService implements TouristService {

    ConductorRepository conductorRepository;
    CustomerRepository customerRepository;
    SuggestedPriceRepository suggestedPriceRepository;
    TripRepository tripRepository;

    @Autowired
    JpaTouristService(ConductorRepository conductorRepository, CustomerRepository customerRepository,
                      SuggestedPriceRepository suggestedPriceRepository, TripRepository tripRepository) {
        this.conductorRepository = conductorRepository;
        this.customerRepository = customerRepository;
        this.suggestedPriceRepository = suggestedPriceRepository;
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
    public SuggestedPrice save(SuggestedPrice suggestedPrice) {
        return suggestedPriceRepository.save(suggestedPrice);
    }

    @Override
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
