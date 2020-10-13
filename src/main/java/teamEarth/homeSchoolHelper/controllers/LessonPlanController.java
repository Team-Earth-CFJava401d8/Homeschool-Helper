package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlan;
import teamEarth.homeSchoolHelper.models.lessonPlan.LessonPlanRepository;

import java.security.Principal;

@Controller
public class LessonPlanController {

    @Autowired
    ChildRepository childRepository;

    @Autowired
    LessonPlanRepository lessonPlanRepository;

    @GetMapping("/lessonPlanner")
    public String planner(){return "lessonPlanner";}

    @PostMapping("/lessonPlan")
    public RedirectView RedirectView(Model m, Principal principal, String planName, Child child) {

        LessonPlan lessonPlan = new LessonPlan(planName);

        lessonPlanRepository.save(lessonPlan);


        return new RedirectView( "/myprofile");
    }


}
