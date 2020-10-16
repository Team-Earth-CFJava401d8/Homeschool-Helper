package teamEarth.homeSchoolHelper.models.post;

import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser applicationUser;

    private String body;
    private Date createdAt;

    public Post() {};

    public Post(ApplicationUser applicationUser, String body) {
        this.applicationUser = applicationUser;
        this.body = body;
        this.createdAt = new Date(Calendar.getInstance().getTime().getTime());
    }

    public String toString() {
        return String.format("%s\n Post made at %s", body, createdAt);
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
