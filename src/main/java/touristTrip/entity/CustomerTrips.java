package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class CustomerTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;

    @ManyToOne
    private Conductor conductor;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JoinColumn(name = "trip_date_id")
    @OneToOne
    private TripDate tripDate;


    @JoinColumn(name = "trip_id")
    @ManyToOne
    private Trip trip;
}
