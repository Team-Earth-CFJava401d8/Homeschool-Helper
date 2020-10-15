package teamEarth.homeSchoolHelper.models.user;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username); // TODO might be a cause for errors?
}
