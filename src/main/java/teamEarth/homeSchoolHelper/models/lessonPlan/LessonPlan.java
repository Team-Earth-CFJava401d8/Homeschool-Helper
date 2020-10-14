package teamEarth.homeSchoolHelper.models.lessonPlan;

import org.springframework.beans.factory.annotation.Autowired;
import teamEarth.homeSchoolHelper.models.book.Book;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.links.Links;
import teamEarth.homeSchoolHelper.models.subCat.SubCat;
import teamEarth.homeSchoolHelper.models.subject.Subject;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

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

    @ManyToMany(mappedBy = "plans")
    public Set<Book> books = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE)

    @JoinTable(
            name="childlessons",
            joinColumns = @JoinColumn(name="child1"),
            inverseJoinColumns = @JoinColumn(name="lesson2")
    )

    public Set<Child> kids = new HashSet<>();

    private String planName;
    private String subject;
    private String url;
    private Long bookId;
    private String creator;
    Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    //========== Constructors ===========
    public LessonPlan(){}

    public LessonPlan(String planName, String subject, SubCat subCat,
                      String url, Long bookId, String creator,
                      Timestamp createdAt) {
        this.planName = planName;
        this.subject = subject;
        this.subCat = subCat;
        this.url = url;
        this.bookId = bookId;
        this.creator = creator;
        this.createdAt = createdAt;
    }

    //========= Getters & Setters ============

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public List<Links> getLinks() {
        return links;
    }
    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public SubCat getSubCat() {
        return subCat;
    }
    public void setSubCat(SubCat subCat) {
        this.subCat = subCat;
    }

    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Child> getKids() {
        return kids;
    }
    public void setKids(Set<Child> kids) {
        this.kids = kids;
    }

    public String getPlanName() {
        return planName;
    }
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    //=========== toString Method ==========

    @Override
    public String toString() {
        return "LessonPlan{ id= " + id +
                ", subCat= " + subCat +
                ", planName='" + planName + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
