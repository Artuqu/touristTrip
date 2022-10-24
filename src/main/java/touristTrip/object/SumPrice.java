package touristTrip.object;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class SumPrice {

    public Long id;

    public String destination;

    @Column(precision = 10, scale = 2)
    public BigDecimal price;

}
