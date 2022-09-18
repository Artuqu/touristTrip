package touristTrip.object;

import ch.qos.logback.core.pattern.Converter;
import lombok.Data;

@Data
public class Trips {
    public Long id;
    public String destination;
    public double price;

}
