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
    private Long customerId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private Long passportNumber;

    private double price;

    @OneToMany
    private List<Trip> trips;

}
