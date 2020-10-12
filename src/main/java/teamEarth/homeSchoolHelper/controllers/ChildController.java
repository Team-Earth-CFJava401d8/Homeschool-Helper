package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlanRepository;

import java.sql.Date;

@Controller
public class ChildController {

    @Autowired
    ChildRepository childRepository;

    //@Autowired
    //LessonPlanRepository lessonPlanRepository;

    //=========== "Add child ============
    @PostMapping("/addChild")
    public RedirectView(String firstName, String lastName, Date dob){

        Child newChild = new Child(firstName, lastName, dob);
        childRepository.save(newChild);

        return new RedirectView("/myprofile");
    }




}
