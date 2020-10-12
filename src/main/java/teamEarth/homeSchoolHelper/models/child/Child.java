package teamEarth.homeSchoolHelper.models.child;

import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

import javax.persistence.*;
import java.sql.Date;

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

    public Child(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
    //====== One to Many (user to children) ====
    @ManyToOne
    ApplicationUser applicationUser;

    //===== Many to Many (lessonPlans to children)
    @ManyToMany(cascade = CascadeType.REMOVE)

    @JoinTable(
            //name="lessons4u",

    )

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
}
