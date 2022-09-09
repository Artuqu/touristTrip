package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long tripId;
    private String destination;
    private Date startDate;
    private Date endDate;
    @OneToOne
    @JoinColumn(name = "price_id")
    private SuggestedPrice price;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;



}
