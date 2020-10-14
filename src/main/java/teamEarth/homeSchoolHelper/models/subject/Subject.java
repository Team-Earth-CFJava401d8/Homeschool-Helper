package teamEarth.homeSchoolHelper.models.subject;

import teamEarth.homeSchoolHelper.models.book.Book;
import teamEarth.homeSchoolHelper.models.subCat.SubCat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    List<SubCat> category = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    List<Book> book = new ArrayList<>();


    private String subjectMatter;

    public Subject() {};
    public Subject(String subjectMatter) {
        this.subjectMatter = subjectMatter;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectMatter() {
        return subjectMatter;
    }
    public void setSubjectMatter(String subjectMatter) {
        this.subjectMatter = subjectMatter;
    }

    public List<SubCat> getCategory() {
        return category;
    }
    public void setCategory(List<SubCat> category) {
        this.category = category;
    }

    //=========== toString method ==========

    @Override
    public String toString() {
        return "Subject{ id= " + id +
                ", subjectMatter='" + subjectMatter + '\'' +
                '}';
    }

}
