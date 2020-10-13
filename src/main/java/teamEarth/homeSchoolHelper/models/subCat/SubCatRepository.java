package teamEarth.homeSchoolHelper.models.subCat;

import org.springframework.data.jpa.repository.JpaRepository;
import teamEarth.homeSchoolHelper.models.subject.Subject;

import java.util.List;

public interface SubCatRepository extends JpaRepository<SubCat, Long> {
    public List<SubCat> findAllSubCatBySubjectId(Long id);
}
