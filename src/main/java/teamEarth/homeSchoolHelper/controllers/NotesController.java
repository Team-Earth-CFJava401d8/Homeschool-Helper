package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.child.Child;
import teamEarth.homeSchoolHelper.models.child.ChildRepository;
import teamEarth.homeSchoolHelper.models.notes.Notes;
import teamEarth.homeSchoolHelper.models.notes.NotesRepository;

import teamEarth.homeSchoolHelper.models.subCat.SubCat;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;

import java.security.Principal;

@Controller
public class NotesController {

    @Autowired
    NotesRepository notesRepository;

    @Autowired
    ChildRepository childRepository;

    @PostMapping("/notes")
    public RedirectView createNote(Principal principal, String notes, Long childId) {
        Child child = childRepository.findById(childId).get();
        Notes note = new Notes(child, notes);
        notesRepository.save(note);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/delete/{id}") // https://www.baeldung.com/spring-boot-crud-thymeleaf
    public RedirectView deleteNote(@PathVariable("id") long id, Model m) {
        Notes note = notesRepository.getOne(id);
        notesRepository.delete(note);
        return new RedirectView("/myprofile");
    }
}
