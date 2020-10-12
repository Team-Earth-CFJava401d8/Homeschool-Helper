package teamEarth.homeSchoolHelper.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Collection;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String userName; // TODO: add to vars list
    String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth; // NOTE: used the java.sql version
    String bio;

    public ApplicationUser(){};

    public ApplicationUser(String userName, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "userName: " + userName + " |" +
                " firstName: " + firstName + " |" +
                " lastName: " + lastName + " |" +
                " dateOfBirth: " + dateOfBirth + " |" +
                " bio: " + bio +
                '}';
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

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
    public String getPassword() { return null; }

    @Override
    public String getUsername() { return null; }

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
