package touristTrip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conductorId;
    private String firstName;
    private String lastName;
    private String pesel;

    @OneToMany
    private List<Trip> trips;

}
