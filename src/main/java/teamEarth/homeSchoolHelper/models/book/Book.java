package teamEarth.homeSchoolHelper.models.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

//    @ManyToOne TODO: Make the connection to lesson plan or children

    public String subject; // TODO: subject is going to be an instance of the subject object
    public String title;
    public String author;
    public String ISBN;
    public String edition;
    public String gradeLevel; // TODO: GradeLevel might be changed to another data type
    public int numberOfUnits;

    public Book() {};

    public Book(String subject, String title, String author, String ISBN, String edition,
                String gradeLevel, int numberOfUnits) {
        this.subject = subject; // TODO: Correlated to the subject variable above
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.edition = edition;
        this.gradeLevel = gradeLevel;
        this.numberOfUnits = numberOfUnits;
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
                " numberOfUnits: " + numberOfUnits +
                '}';
    }
}
