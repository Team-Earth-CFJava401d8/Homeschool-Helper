package teamEarth.homeSchoolHelper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import teamEarth.homeSchoolHelper.models.notes.Notes;
import teamEarth.homeSchoolHelper.models.post.Post;
import teamEarth.homeSchoolHelper.models.post.PostRepository;
import teamEarth.homeSchoolHelper.models.user.ApplicationUser;
import teamEarth.homeSchoolHelper.models.user.ApplicationUserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/createPost")
    public RedirectView createPost(Model m, Principal principal, String body, Long userId) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        ApplicationUser userPost = applicationUserRepository.findById(userId).get();
        Post post = new Post(user, body);
        postRepository.save(post);
        List<Post> posts = postRepository.findAll();

        m.addAttribute("userPost", userPost);
        m.addAttribute("posts", posts);
        return new RedirectView("/forum");
    }

    @GetMapping("/deletePost/{id}")
    public RedirectView deletePost(@PathVariable("id") long id, Model m) {
        Post post = postRepository.getOne(id);
        postRepository.delete(post);
        return new RedirectView("/forum");
    }

    @GetMapping("/forum")
    public String showForum(Model m, Principal principal) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        List<Post> posts = postRepository.findAll();

        m.addAttribute("posts", posts);
        m.addAttribute("user", user);
        m.addAttribute("principal", principal);
        return "forum";
    }
}
