package teamEarth.homeSchoolHelper.models.child;

import org.springframework.beans.factory.annotation.Autowired;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlanRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Child {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;

    public String firstName;
    public String lastName;
    public Date dob;

    //=========== Constructors ================
    public Child() {};

    public Child(ApplicationUser applicationUser, String firstName, String lastName, Date dob) {
        this.applicationUser = applicationUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
    //====== One to Many (user to children) ====
    @ManyToOne
    ApplicationUser applicationUser;
//////////////////////////////////////////////////
    //===== Many to Many (lessonPlans to children)
//    @ManyToMany(cascade = CascadeType.REMOVE)
//
//    @JoinTable(
//            name="lessons4u",
//            joinColumns =  @JoinColumn(name="lesson2"),
//            inverseJoinColumns = @JoinColumn(name="child1")
//    )
//
//    public Set<LessonPlan> lessonPlans = new HashSet<>();
/////////////////////////////////////////////////////
    @ManyToMany (mappedBy = "kids")
    public Set<LessonPlan> plans = new HashSet<>();

    //=========== Getters & Setters ==========


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
