package touristTrip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
    @OneToOne
    @JoinColumn(name = "price_id")
    private SuggestedPrice price;

}
