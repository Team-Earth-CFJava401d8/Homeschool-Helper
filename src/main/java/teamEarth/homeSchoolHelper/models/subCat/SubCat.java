package teamEarth.homeSchoolHelper.models.subCat;

import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;
import teamEarth.homeSchoolHelper.models.subject.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubCat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Subject subject;

    @OneToMany(mappedBy = "subCat", cascade = CascadeType.ALL)
    List<LessonPlan> lessons = new ArrayList<>();

    private String categoryName;

    public SubCat() {};

    public SubCat(Subject subject, String categoryName) {
        this.subject = subject;
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<LessonPlan> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonPlan> lessons) {
        this.lessons = lessons;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
