package teamEarth.homeSchoolHelper.models.subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public Subject findBySubjectMatter(String subjectMatter);
}
