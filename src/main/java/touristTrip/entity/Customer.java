package touristTrip.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="Please write your first name")
    private String firstName;

    @NotBlank(message ="Please write your last name")
    private String lastName;


//    @PassportInterface
    @Pattern(regexp = "^\\D{2}[0-9]{7}$", message = "Incorrect passport number")
    @Column(unique = true, columnDefinition = "char(9)")
    @NotBlank(message ="Please write your passport number")
    private String passportNumber;

    @OneToMany(mappedBy = "customer")
    @Cascade(CascadeType.DELETE)
    private List<CustomerTrips> customerTrips;
}
