package touristTrip.service;

import touristTrip.entity.Conductor;
import touristTrip.entity.Customer;
import touristTrip.entity.SuggestedPrice;
import touristTrip.entity.Trip;

import java.util.List;

public interface TouristService {

    Conductor save (Conductor conductor);
    Customer save (Customer customer);
    Customer findCustomer (Long customerId);
    SuggestedPrice save (SuggestedPrice suggestedPrice);
    Trip save (Trip trip);

    List<Customer> findAllCustomers();

    void deleteCustomer (Long customerId);
}
