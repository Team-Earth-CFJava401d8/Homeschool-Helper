package teamEarth.homeSchoolHelper.models.lessonPlan;

import org.springframework.beans.factory.annotation.Autowired;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.links.Links;
import teamEarth.homeSchoolHelper.models.subCat.SubCat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class LessonPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    //======= One to Many ==================
    @OneToMany(mappedBy = "lessonPlan", cascade = CascadeType.ALL)
    public List<Links> links = new ArrayList<>();

    //======== Many to One =================
    @ManyToOne
    SubCat subCat;

    //======== Many to Many =================

    @ManyToMany(cascade = CascadeType.REMOVE)

    @JoinTable(
            name="childlessons",
            joinColumns = @JoinColumn(name="child1"),
            inverseJoinColumns = @JoinColumn(name="lesson2")
    )

    public Set<Child> kids = new HashSet<>();

    public String planName;
//    public String subject; // TODO: change to subject obj once subject obj's are created
//    public Child child;
    //public List link;
    //public Unit unit;

    Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    //public String content;

    //========== Constructors ===========
    public LessonPlan(){}

    public LessonPlan(String planName) {
        this.planName = planName;
        this.createdAt = new Timestamp(System.currentTimeMillis());

    }

    //========= Getters & Setters ============


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }
}
