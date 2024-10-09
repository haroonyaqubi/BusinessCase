package BusinessCase.fr.businessCase.Repository;

import BusinessCase.fr.businessCase.entity.Booking;
import BusinessCase.fr.businessCase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking, String> {

}
