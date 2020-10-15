package teamEarth.homeSchoolHelper.models.links;

import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;

import javax.persistence.*;

@Entity
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    //============== Many to One =================
    @ManyToOne
    LessonPlan lessonPlan;

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
}
