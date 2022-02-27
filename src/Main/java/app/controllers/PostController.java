package app.controllers;

import app.dao.PostRepository;
import app.dto.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/Test")
    public List<Posts> findall(){
        return postRepository.findAll();
    }


    @GetMapping("/Test2")
    public Posts findID(){
        return postRepository.getById(1);
    }

    @GetMapping("/Test3")
    public long find(){
        return postRepository.count();
    }

}
