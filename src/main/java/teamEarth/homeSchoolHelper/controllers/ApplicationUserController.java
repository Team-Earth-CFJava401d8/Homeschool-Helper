package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlanRepository;
import teamEarth.homeSchoolHelper.models.notes.Notes;
import teamEarth.homeSchoolHelper.models.notes.NotesRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;
import teamEarth.homeSchoolHelper.models.user.ApplicationUserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Date;
import java.util.*;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    LessonPlanRepository lessonPlanRepository;

    @Autowired
    NotesRepository notesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public ModelAndView newUser(String username,
                                String password,
                                String firstName,
                                String lastName,
                                Date dateOfBirth,
                                String bio,
                                HttpServletRequest request) {

        password = passwordEncoder.encode(password);

        ApplicationUser newUser = new ApplicationUser(username, password, firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        System.out.println(newUser + "Here's the password" + newUser.password);
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);

        return new ModelAndView("redirect:/login"); // now TEMPORARILY redirects login with this content, redirecting straight through /login,
    } // ^^^ https://www.baeldung.com/spring-redirect-and-forward

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/myprofile")
    public String showMyProfile(Model m, Principal principal) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());

        List<LessonPlan> lessonPlans = lessonPlanRepository.findAll();
        List<Child> usersChildren = user.children;
        //Creating an array list where each element is a list of each individual child's notes
        ArrayList<List<Notes>> childNotes = new ArrayList<>();


        for (int i = 0; i < usersChildren.size(); i++) {
            long childId = usersChildren.get(i).getId();
            List<Notes> thisNotesList = notesRepository.findAllNotesByChildId(childId);
            childNotes.add(thisNotesList);
        }

        m.addAttribute("childNotes", childNotes);
        m.addAttribute("plans", lessonPlans);
        m.addAttribute("user", user);
        m.addAttribute("children", usersChildren);
        m.addAttribute("principal", principal);
        return "myprofile";
    }
}

