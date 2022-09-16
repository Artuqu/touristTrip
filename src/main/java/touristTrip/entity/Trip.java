package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;
    private String images;
    private String destination;
    private String description;

    @OneToMany
    private List<TripDate> tripDate;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "passport_number")
    private Customer customers;


}
