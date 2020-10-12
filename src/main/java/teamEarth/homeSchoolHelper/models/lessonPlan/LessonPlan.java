package teamEarth.homeSchoolHelper.models.lessonPlan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class LessonPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public String planName;
    public Date planDate;
    public String subject; // TODO: change to subject obj once subject obj's are created
    public String child; // TODO: change to child obj
    public String content;


}
