package touristTrip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Can't be blank")
    private String firstName;
    @NotBlank
    private String lastName;

    private String passportNumber;

    private double price;

    @ManyToMany
    @JoinColumn(name = "trip_id")
    private List<Trip> trips;

}
