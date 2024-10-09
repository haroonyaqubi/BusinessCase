package BusinessCase.fr.businessCase.Repository;

import BusinessCase.fr.businessCase.entity.User;
import BusinessCase.fr.businessCase.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewRepository extends JpaRepository <UserReview, Long> {

}
