package app.controllers;

import app.dao.PostRepository;
import app.dto.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    HashtagController hashController;

    @RequestMapping("/")
    public String begin(){
        hashController.startUp();
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
        hashController.findHash(post);
        return "redirect:/getPosts";
    }

    @PersistenceContext
    EntityManager entityManager;



    @PostMapping("/searchBlog")
    public String searchBlog(Model model,String search){
        String name = search;
        List<Long> hashes = new ArrayList<>();
        List<Long> postIDs = new ArrayList<>();
        try {
            hashes = entityManager.createQuery("select hashtagid from Hashtags where phrase =:hashName").setParameter("hashName", name).getResultList();
            postIDs = entityManager.createQuery("select postid from posts_hashtags where hashtagid =:thisHash").setParameter("thisHash", hashes.get(0)).getResultList();
        }
        catch (Exception e){
            return "MyBlog.html";
        }
        model.addAttribute("getPosts", postRepository.findAllById(postIDs));
        return "MyBlog.html";
    }



}   // End class
