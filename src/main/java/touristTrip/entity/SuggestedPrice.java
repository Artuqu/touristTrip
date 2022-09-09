package touristTrip.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SuggestedPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;
    private Long price;
}
