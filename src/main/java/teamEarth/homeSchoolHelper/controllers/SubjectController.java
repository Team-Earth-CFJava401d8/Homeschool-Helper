package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.subCat.SubCat;
import teamEarth.homeSchoolHelper.models.subCat.SubCatRepository;
import teamEarth.homeSchoolHelper.models.subject.Subject;
import teamEarth.homeSchoolHelper.models.subject.SubjectRepository;



@Controller
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubCatRepository subCatRepository;

    // Creating a new subject matter
    @PostMapping("/createSubject")
    public RedirectView addSubject(Model m, String subjectMatter) {
        Subject subject = new Subject(subjectMatter);
        subjectRepository.save(subject);

        m.addAttribute("subject", subject);
        return new RedirectView("/lessonPlanner");
    }

    // Linking sub category to subject matter and saving sub category to database
    @PostMapping("/createSubCat")
    public RedirectView addSubCat(String categoryName, Long subjectId) {
        System.out.println("subid " + subjectId);
        Subject subject = subjectRepository.findById(subjectId).get();
       // Subject subject = subjectRepository.findBySubjectMatter(subjectName);
        System.out.println("the subject" + subject);
        SubCat subCat = new SubCat(subject, categoryName);

        subject.category.add(subCat);


        subCatRepository.save(subCat);
        return new RedirectView("/lessonPlanner");
    }
}
