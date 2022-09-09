package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import touristTrip.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
