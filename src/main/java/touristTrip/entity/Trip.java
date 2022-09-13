package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;
    private String destination;
    private Date tripDate;
    @OneToOne
    @JoinColumn(name = "price_id")
    private SuggestedPrice price;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "passport_number")
    private Customer customers;


}
