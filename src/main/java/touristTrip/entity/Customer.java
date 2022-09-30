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

    @NotBlank(message ="Please write your first name")
    private String firstName;

    @NotBlank(message ="Please write your last name")
    private String lastName;

    @NotBlank(message ="Please write your passport number")
    private String passportNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<CustomerTrips> customerTrips;
}
