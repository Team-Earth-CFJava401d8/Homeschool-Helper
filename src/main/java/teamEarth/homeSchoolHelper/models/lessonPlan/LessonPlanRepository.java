package teamEarth.homeSchoolHelper.models.lessonPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

public interface LessonPlanRepository extends JpaRepository<LessonPlan, Long> {
}
