package teamEarth.homeSchoolHelper.models.links;

import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;
import teamEarth.homeSchoolHelper.models.subject.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    //============== Many to One =================
    @ManyToOne
    Subject subject;

    @ManyToMany(cascade = CascadeType.REMOVE)

    @JoinTable(
            name="linkLessons",
            joinColumns = @JoinColumn(name="link"),
            inverseJoinColumns = @JoinColumn(name="lesson")
    )
    public List<LessonPlan> lessonPlans = new LinkedList<>();

    private String url;
    private String description;

    //============ Constructors =================
    public Links() {};

    public Links(String url, String description) {
        this.url = url;
        this.description = description;
    }


    //============== Getters & Setters ===========

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LessonPlan> getLessonPlans() {
        return lessonPlans;
    }

    public void setLessonPlans(
            List<LessonPlan> lessonPlans) {
        this.lessonPlans = lessonPlans;
    }
}
