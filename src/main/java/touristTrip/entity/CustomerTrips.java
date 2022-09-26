package touristTrip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class CustomerTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    @ManyToOne
//    @NotNull
    private Conductor conductor;


    @ManyToOne(fetch = FetchType.EAGER)
//    @NotNull
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JoinColumn(name = "trip_date_id")
//    @NotNull
    @OneToOne
    private TripDate tripDate;


    @JoinColumn(name = "trip_id")
//    @NotNull
    @ManyToOne
    private Trip trip;
}
