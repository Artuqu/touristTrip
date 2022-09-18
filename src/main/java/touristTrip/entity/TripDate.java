package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TripDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tripId;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToOne(mappedBy = "tripDate")
    private CustomerTrips customerTrips;
}
