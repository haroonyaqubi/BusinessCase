package BusinessCase.fr.businessCase.Repository;

import BusinessCase.fr.businessCase.entity.User;
import BusinessCase.fr.businessCase.entity.UserLocalisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocalisationRepository extends JpaRepository <UserLocalisation, Long> {

}
