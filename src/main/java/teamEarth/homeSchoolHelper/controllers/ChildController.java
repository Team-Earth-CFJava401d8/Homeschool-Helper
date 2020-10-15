package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;
import teamEarth.homeSchoolHelper.models.user.ApplicationUserRepository;

import java.security.Principal;
import java.sql.Date;

@Controller
public class ChildController {

    @Autowired
    ChildRepository childRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;



    //=========== "Add child ============
    @GetMapping("/addChild")
    public String addChild(){ return "addChild";}

    @PostMapping("/addChild")
    public RedirectView RedirectView(String firstName, String lastName, Date dob, Principal principal){

        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        Child newChild = new Child(user, firstName, lastName, dob);
        childRepository.save(newChild);

        return new RedirectView("/myprofile");
    }




}
