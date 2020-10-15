package teamEarth.homeSchoolHelper.models.child;

import org.springframework.data.jpa.repository.JpaRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

public interface ChildRepository extends JpaRepository<Child, Long> {

}
