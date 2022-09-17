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

    @OneToMany
    private List<TripDate> tripDate;

    private double price;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @ManyToMany
    @JoinColumn(name = "customer_id")
    private List<Customer> customers;


}
