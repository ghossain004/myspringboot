package com.spring.socialbook.controller;

import com.spring.socialbook.entity.User;
import com.spring.socialbook.repository.SBRepository;
import com.spring.socialbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PostController {

    @Autowired
    SBRepository repository;

    @Autowired
    PostService service;

    @GetMapping("/posts")
    List<User> all(){
        System.out.println("Get all called");
        return repository.findAll();
    }

    @PostMapping("/posts")
    User newPost(@RequestBody User newUser){
        return repository.save(newUser);
    }

    @PutMapping("/post/{id}")
    User updateUser(@RequestBody User signUp, @PathVariable Long id){
        return repository.findById(id).map(post->{
            post.setFirstName(signUp.getFirstName());
            post.setLastName(signUp.getLastName());
            post.setEmail(signUp.getEmail());
            post.setDob(signUp.getDob());
            post.setGender(signUp.getGender());
            return repository.save(post);
        }).orElseGet(() ->{
            signUp.setUserId(id);
            return repository.save(signUp);
        });
    }

    @DeleteMapping("/posts/{id}")
    void deleteUser(@PathVariable Long id) {repository.deleteById(id);}

//    Single Item

    @GetMapping("/posts/{id}")
    User oneUser(@PathVariable Long id) {
        Optional<User> signUp = repository.findById(id);
        return signUp.get();
    }
}
