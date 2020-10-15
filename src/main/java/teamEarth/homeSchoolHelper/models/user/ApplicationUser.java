package teamEarth.homeSchoolHelper.models.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String username; // TODO: add to vars list BECAUSE IT'S ALL lowercase. why? BECAUSE.
    public String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth; // NOTE: used the java.sql version
    String bio;

    public ApplicationUser(){};

    public ApplicationUser(String username, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    @OneToMany(mappedBy = "applicationUser", cascade = CascadeType.ALL)
    public List<Child> children = new ArrayList<>();

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "userName: " + username + " |" +
                " firstName: " + firstName + " |" +
                " lastName: " + lastName + " |" +
                " dateOfBirth: " + dateOfBirth + " |" +
                " bio: " + bio +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() { return username; }
    public void setUserName(String userName) { this.username = userName; }

    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }

    @Override
    public String getPassword() { return password; } // TODO: Always ensure it RETURNS IT.

    @Override
    public String getUsername() { return username; } // TODO: Always ensure it RETURNS IT.

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true;
    }

    @Override
    public boolean isEnabled() { return true; }
}
