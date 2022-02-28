package app.controllers;

import app.dao.PostRepository;
import app.dto.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class PostController {
    @Autowired
    PostRepository postRepository;

    @RequestMapping("/")
    public String begin(){
        return "Index.html";
    }

    @GetMapping("/Test")
    public List<Posts> findall(){
        return postRepository.findAll();
    }

    @GetMapping("getPosts")
    public String displayHeroes(Model model) {
        model.addAttribute("getPosts",postRepository.findAll());
        return "MyBlog.html";
    }

    @GetMapping("enterNewPost")
    public String newPost(String description) {
        System.out.println(description);
        Posts post = new Posts(description);
        postRepository.save(post);
        return "redirect:/getPosts";
    }


    @GetMapping("/Test3")
    public long find(){
        return postRepository.count();
    }

}   // End class
