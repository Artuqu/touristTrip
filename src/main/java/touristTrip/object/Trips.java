package touristTrip.object;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trips {

    public Long id;

    public String destination;
    @Column(precision = 5, scale = 4)
    public double price;

}
