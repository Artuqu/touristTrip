package touristTrip.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Trips {
    @Id
    public Long id;
    @JsonProperty(value = "text")
    public String destination;

    @JsonProperty(value = "text")
    public double price;

}
