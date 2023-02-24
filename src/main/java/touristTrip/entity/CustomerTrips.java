package touristTrip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTrips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 7, scale = 2)
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
