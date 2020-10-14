package teamEarth.homeSchoolHelper.models.notes;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface NotesRepository extends JpaRepository<Notes, Long> {
    public List<Notes> findAllNotesByChildId(Long id);
}
