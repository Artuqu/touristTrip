package touristTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import touristTrip.entity.SuggestedPrice;

@Repository
public interface SuggestedPriceRepository extends JpaRepository<SuggestedPrice,Long> {


}
