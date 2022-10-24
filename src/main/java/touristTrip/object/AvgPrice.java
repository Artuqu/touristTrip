package touristTrip.object;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AvgPrice {

    public Long id;

    public String destination;

    @Column(precision = 10, scale = 2)
    public double price;

}
