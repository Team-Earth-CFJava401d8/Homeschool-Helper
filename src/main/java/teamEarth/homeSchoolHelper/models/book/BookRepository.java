package teamEarth.homeSchoolHelper.models.book;

import org.springframework.data.jpa.repository.JpaRepository;
import teamEarth.homeSchoolHelper.models.subCat.SubCat;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findAllBooksBySubjectId(Long id);
}
