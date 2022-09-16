package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class TripDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripDateId;

    private Long tripId;

    @ManyToOne
    private Trip trip;


    private LocalDate startDate;

    private LocalDate endDate;
}
