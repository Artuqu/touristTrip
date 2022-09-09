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
    private String firsName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Long passportNumber;
    @OneToOne
    @JoinColumn(name = "price_id")
    private SuggestedPrice price;

}
