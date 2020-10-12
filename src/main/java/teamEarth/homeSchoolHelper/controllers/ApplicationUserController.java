package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;
import teamEarth.homeSchoolHelper.models.user.ApplicationUserRepository;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

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
}

