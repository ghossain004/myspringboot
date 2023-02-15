package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Signup;
import com.spring.socialbook.repository.UserRepository;
import com.spring.socialbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService service;

    @GetMapping("/posts")
    List<Signup> all(){
        System.out.println("Get all called");
        return userRepository.findAll();
    }

    @PostMapping("/posts")
    Signup newPost(@RequestBody Signup newUser){
        return userRepository.save(newUser);
    }

    @PutMapping("/post/{id}")
    Signup updateUser(@RequestBody Signup signUp, @PathVariable Long id){
        return userRepository.findById(id).map(post->{
            post.setFirstName(signUp.getFirstName());
            post.setLastName(signUp.getLastName());
            post.setEmail(signUp.getEmail());
            post.setDob(signUp.getDob());
            post.setGender(signUp.getGender());
            return userRepository.save(post);
        }).orElseGet(() ->{
            signUp.setUserId(id);
            return userRepository.save(signUp);
        });
    }

    @DeleteMapping("/posts/{id}")
    void deleteUser(@PathVariable Long id) {userRepository.deleteById(id);}

//    Single Item

    @GetMapping("/posts/{id}")
    Signup oneUser(@PathVariable Long id) {
        Optional<Signup> signUp = userRepository.findById(id);
        return signUp.get();
    }
}
