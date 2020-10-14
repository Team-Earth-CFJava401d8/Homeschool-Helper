package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.book.Book;
import teamEarth.homeSchoolHelper.models.book.BookRepository;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlanRepository;
import teamEarth.homeSchoolHelper.models.links.Links;
import teamEarth.homeSchoolHelper.models.links.LinksRepository;
import teamEarth.homeSchoolHelper.models.subCat.SubCat;
import teamEarth.homeSchoolHelper.models.subCat.SubCatRepository;
import teamEarth.homeSchoolHelper.models.subject.Subject;
import teamEarth.homeSchoolHelper.models.subject.SubjectRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;
import teamEarth.homeSchoolHelper.models.user.ApplicationUserRepository;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class LessonPlanController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LinksRepository linksRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    LessonPlanRepository lessonPlanRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubCatRepository subCatRepository;

    // Grabbing list of subjects from database to be used in add a lesson plan form
    @GetMapping("/lessonPlanner")
    public String planner(Model m, Principal principal) {
        List<Subject> subjects = subjectRepository.findAll();
        m.addAttribute("monkey", subjects);
        return "lessonPlanner";
    }

    // Making the properties of lesson planner available for the user to create lesson plan
    @PostMapping("/lessonPlanner")
    public String planner2(Model m, Principal principal, Long subjectId) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        Subject subject = subjectRepository.findById(subjectId).get();
        List<SubCat> subCats = subCatRepository.findAllSubCatBySubjectId(subjectId);
        List<Book> books = bookRepository.findAllBooksBySubjectId(subjectId);
        List<Links> links = linksRepository.findAll();

        m.addAttribute("subject", subject);
        m.addAttribute("user", user);
        m.addAttribute("books", books);
        m.addAttribute("links", links);
        m.addAttribute("panda", subCats);
        return "lessonPlanner";
    }

    // Create the lesson plan and save to the database
    @PostMapping("/createLessonPlan")
    public RedirectView RedirectView(Model m, Principal principal,
                                     String planName, String subject,
                                     Long subCatId, String links,
                                     Long booksId, String creator) {

        SubCat category = subCatRepository.findById(subCatId).get();
        //Book book = bookRepository.findById(booksId).get();
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

        LessonPlan lessonPlan = new LessonPlan(planName, subject, category,
                                               links, booksId, creator, createdAt);
        lessonPlanRepository.save(lessonPlan);

        return new RedirectView( "/myprofile");
    }

    // Assigning a lesson to a child
    @PostMapping("/assignLesson")
    public RedirectView redirectview(Model m, Principal principal, Long child, Long lesson){

        Child assignedChild = childRepository.getOne(child);
        LessonPlan lessonToAssign = lessonPlanRepository.findById(lesson).get();

        assignedChild.plans.add(lessonToAssign);
        lessonToAssign.kids.add(assignedChild);

        childRepository.save(assignedChild);
        lessonPlanRepository.save(lessonToAssign);

        m.addAttribute("principal", principal);

        return new RedirectView("/myprofile");
    }


}
