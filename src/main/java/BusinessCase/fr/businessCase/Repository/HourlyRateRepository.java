package BusinessCase.fr.businessCase.Repository;

import BusinessCase.fr.businessCase.entity.HourlyRate;
import BusinessCase.fr.businessCase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourlyRateRepository extends JpaRepository <HourlyRate, Long> {

}
