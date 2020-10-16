package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.links.Links;
import teamEarth.homeSchoolHelper.models.links.LinksRepository;

@Controller
public class LinkController {

    @Autowired
    LinksRepository linksRepository;

    // Create a link and saving to the database
   @PostMapping("/createLink")
    public RedirectView createLink(String url, String desc){

       Links newLink = new Links(url, desc);
       linksRepository.save(newLink);

       return new RedirectView("/lessonPlanner");
   }

}
