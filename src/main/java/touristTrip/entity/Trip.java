package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String images;
    private String destination;
    private String description;

    @Column(precision = 7, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @OneToOne
    @JoinColumn(name = "tripId")
    private TripDate tripDate;

    @OneToMany(mappedBy = "trip")
    private List<CustomerTrips> customerTrips;
}
