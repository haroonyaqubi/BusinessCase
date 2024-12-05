package BusinessCase.fr.businessCase.Repository;

import BusinessCase.fr.businessCase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

    Optional<User> findUserByActivationCode(String code);

    Optional<User> findUserByEmailAndActivationCodeIsNull(String email);

}
