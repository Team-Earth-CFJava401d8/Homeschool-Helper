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
import java.util.List;

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

    @PostMapping("/assignLesson")
    public RedirectView redirectview(Model m, Principal principal, Long child, Long lesson){

        Child assignedChild = childRepository.getOne(child);
        LessonPlan lessonToAssign = lessonPlanRepository.findById(lesson).get();

        assignedChild.plans.add(lessonToAssign);
        lessonToAssign.kids.add(assignedChild);

        childRepository.save(assignedChild);
        lessonPlanRepository.save(lessonToAssign);

        //m.addAttribute("principal", principal);

        return new RedirectView("/myprofile");
    }


}
