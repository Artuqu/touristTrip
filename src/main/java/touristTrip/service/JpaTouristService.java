package touristTrip.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import touristTrip.entity.*;
import touristTrip.object.SumPrice;
import touristTrip.object.AvgPrice;
import touristTrip.repository.*;

import java.util.List;

@Service
public class JpaTouristService implements TouristService {

    private ConductorRepository conductorRepository;
    private CustomerRepository customerRepository;
    private TripDateRepository tripDateRepository;
    private TripRepository tripRepository;
    @PersistenceContext
    private EntityManager em;

    private CustomerTripsRepository customerTripsRepository;
    private String startDate = "'2022-01-01'";
    private String endDate = "'2023-12-31'";

    @Autowired
    JpaTouristService(ConductorRepository conductorRepository, CustomerRepository customerRepository,
                      TripDateRepository tripDateRepository, TripRepository tripRepository,
                      CustomerTripsRepository customerTripsRepository, EntityManager em) {
        this.conductorRepository = conductorRepository;
        this.customerRepository = customerRepository;
        this.tripDateRepository = tripDateRepository;
        this.tripRepository = tripRepository;
        this.customerTripsRepository = customerTripsRepository;
        this.em = em;
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

    @Override
    public void deleteAllCustomerTrips(Long customerId) {
        customerTripsRepository.deleteAllCustomerTripsByCustomerId(customerId);
    }

    @Override
    public List<AvgPrice> avgPriceList() {
        TypedQuery<AvgPrice> query = em.createQuery("SELECT new touristTrip.object.AvgPrice(t.id, t.destination, Round(avg(ct.price),2) ) FROM Trip t " +
                "INNER JOIN CustomerTrips ct ON ct.trip=t.id INNER JOIN TripDate td ON td.id=ct.trip WHERE td.startDate BETWEEN " + startDate + " AND " + endDate + "GROUP BY t.id", AvgPrice.class);
        List result = query.getResultList();
        return result;
    }

    @Override
    public List<SumPrice> getSum() {
        TypedQuery<SumPrice> query = em.createQuery("SELECT new touristTrip.object.SumPrice (count(t.id), t.destination, Round(sum(ct.price),2) ) FROM Trip t " +
                "INNER JOIN CustomerTrips ct ON t.id=ct.trip INNER JOIN TripDate td ON td.id=ct.trip WHERE td.startDate BETWEEN " + startDate + " AND " + endDate + "GROUP BY t.id", SumPrice.class);
        List result = query.getResultList();
        return result;
    }


}
