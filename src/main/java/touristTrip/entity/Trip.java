package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    private double price;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @OneToOne
    @JoinColumn(name = "tripId")
    private TripDate tripDate;

    @OneToMany(mappedBy = "trip", orphanRemoval = true)
    private List<CustomerTrips> customerTrips;
}
