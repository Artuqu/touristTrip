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
    private Long id;
    private String fullName;
    @PESEL
    private String pesel;

    @OneToMany(mappedBy = "conductor")
    private List<CustomerTrips> customerTrips;


}
