package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.book.Book;
import teamEarth.homeSchoolHelper.models.book.BookRepository;
import teamEarth.homeSchoolHelper.models.subject.Subject;
import teamEarth.homeSchoolHelper.models.subject.SubjectRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    BookRepository bookRepository;

    // Grabbing list of subjects from database to be used in add a book form
    @GetMapping("/book")
    public String planner(Model m, Principal principal) {
        List<Subject> subjects = subjectRepository.findAll();
        m.addAttribute("subjects", subjects);
        return "book";
    }

    //Adding book to the database
    @PostMapping("/createBook")
    public RedirectView createBook(Model m, Principal principal, Subject subject, String title,
                                   String author, String ISBN, int edition, int gradeLevel,
                                   int numberOfPages) {
        Book book = new Book(subject, title, author, ISBN, edition, gradeLevel, numberOfPages);
        bookRepository.save(book);
        return new RedirectView("/lessonPlanner");
    }

}
