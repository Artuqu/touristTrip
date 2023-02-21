package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select customer.id, first_name, last_name, passport_number from customer left join " +
            "customer_trips on customer_trips.customer_id=customer.id where customer_trips.customer_id is null;", nativeQuery = true)
    List<Customer> customersWithoutTrip();

}
