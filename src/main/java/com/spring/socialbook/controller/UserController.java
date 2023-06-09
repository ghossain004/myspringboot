package com.spring.socialbook.controller;

import com.spring.socialbook.entity.User;
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

    @GetMapping("/signup")
    List<User> all(){
        System.out.println("Get all called");
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    User newPost(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @PutMapping("/signup/{id}")
    User updateUser(@RequestBody User signUp, @PathVariable Long id){
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

    @DeleteMapping("/signup/{id}")
    void deleteUser(@PathVariable Long id) {userRepository.deleteById(id);}

//    Single Item

    @GetMapping("/signup/{id}")
    User oneUser(@PathVariable Long id) {
        Optional<User> signUp = userRepository.findById(id);
        return signUp.get();
    }
}
