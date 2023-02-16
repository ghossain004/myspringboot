package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Post;
import com.spring.socialbook.entity.User;
import com.spring.socialbook.repository.PostRepository;
import com.spring.socialbook.repository.SBRepository;
import com.spring.socialbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    PostService service;

    @GetMapping("/posts")
    List<Post> all(){
        System.out.println("Get all called");
        return repository.findAll();
    }

    @PostMapping("/posts")
    Post newPost(@RequestBody Post post){

        post.setCreateTime(LocalTime.now());
        post.setCreateDate(LocalDate.now());
        return repository.save(post);
    }

    @PutMapping("/post/{id}")
    Post updateUser(@RequestBody Post posts, @PathVariable Long id){
        return repository.findById(id).map(post->{
            post.setPostBody(posts.getPostBody());
            return repository.save(post);
        }).orElseGet(() ->{
            posts.setUserId(id);
            return repository.save(posts);
        });
    }

    @DeleteMapping("/posts/{id}")
    void deleteUser(@PathVariable Long id) {
        System.out.println("delete check");
        repository.deleteById(id);}

//    Single Item

    @GetMapping("/posts/{id}")
    Post oneUser(@PathVariable Long id) {
        Optional<Post> post = repository.findById(id);
        return post.get();
    }
}
