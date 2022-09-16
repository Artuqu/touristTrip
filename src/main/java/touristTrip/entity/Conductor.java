package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import java.util.List;

@Data
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conductorId;
    private String fullName;
    @PESEL
    private String pesel;

    @OneToMany
    private List<Trip> trips;

}
