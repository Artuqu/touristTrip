package touristTrip.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import touristTrip.object.AvgPrice;
import touristTrip.object.SumPrice;

import java.util.List;

public class TripRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    TripRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private final String startDate = "'2022-01-01'";
    private final String endDate = "'2023-12-31'";


    public List<AvgPrice> avgPriceList() {
        TypedQuery<AvgPrice> query = entityManager.createQuery("SELECT new touristTrip.object.AvgPrice(t.id, t.destination, Round(avg(ct.price),2) as price ) FROM Trip t " +
                "INNER JOIN CustomerTrips ct ON ct.trip=t.id INNER JOIN TripDate td ON td.id=ct.trip WHERE td.startDate BETWEEN " + startDate + " AND " + endDate + "GROUP BY t.id", AvgPrice.class);
        return query.getResultList();
    }


    public List<SumPrice> getSum() {
        TypedQuery<SumPrice> query = entityManager.createQuery("SELECT new touristTrip.object.SumPrice (count(t.id), t.destination, sum(ct.price) ) FROM Trip t " +
                "INNER JOIN CustomerTrips ct ON t.id=ct.trip INNER JOIN TripDate td ON td.id=ct.trip WHERE td.startDate BETWEEN " + startDate + " AND " + endDate + "GROUP BY t.id", SumPrice.class);
        return query.getResultList();
    }
}
