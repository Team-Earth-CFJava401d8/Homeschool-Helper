package teamEarth.homeSchoolHelper.models.lessonPlan;

import teamEarth.homeSchoolHelper.models.child.Child;

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

    public String planName;
//    public String subject; // TODO: change to subject obj once subject obj's are created
   // public Child child;
    //public Link link;
    //public Unit unit;

    Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    //public String content;

    //========== Constructors ===========
    public LessonPlan(){}

    public LessonPlan(String planName) {
        this.planName = planName;
        this.createdAt = new Timestamp(System.currentTimeMillis());
       // this.child = child;
    }

    //======== Many to Many =================
    @ManyToMany(cascade = CascadeType.REMOVE)

    @JoinTable(
            name="childlessons",
            joinColumns = {@JoinColumn(name="child1")},
            inverseJoinColumns = {@JoinColumn(name="lesson2")}
    )

    public Set<LessonPlan> plans = new HashSet<>();

    @ManyToMany(mappedBy = "plans")
    //public List<Child> kids = new ArrayList<>();

    //========= Getters & Setters ============

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
}
