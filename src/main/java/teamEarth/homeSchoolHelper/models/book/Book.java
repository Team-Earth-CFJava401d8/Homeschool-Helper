package teamEarth.homeSchoolHelper.models.book;

import teamEarth.homeSchoolHelper.models.subject.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;


    @ManyToOne
    Subject subject;

    private String title;
    private String author;
    private String ISBN;
    private int edition;
    private int gradeLevel;
    private int numberOfPages;

    public Book() {};

    public Book(Subject subject, String title, String author, String ISBN, int edition,
                int gradeLevel, int numberOfPages) {
        this.subject = subject;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.edition = edition;
        this.gradeLevel = gradeLevel;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "subject: " + subject + " |" +
                " title: " + title + " |" +
                " author: " + author + " |" +
                " ISBN: " + ISBN + " |" +
                " edition: " + edition + " |" +
                " gradeLevel: " + gradeLevel + " |" +
                " numberOfPages: " + numberOfPages +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getNumberOfUnits() {
        return numberOfPages;
    }

    public void setNumberOfUnits(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
