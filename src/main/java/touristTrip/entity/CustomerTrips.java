package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CustomerTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    @ManyToOne
    private Conductor conductor;


    @ManyToOne
    @JoinColumn(name = "customer_id", updatable = false)
    private Customer customer;

    @JoinColumn(name = "trip_date_id", updatable = false)
    @OneToOne
    private TripDate tripDate;

    @JoinColumn(name = "trip_id", updatable = false)
    @ManyToOne
    private Trip trip;
}
