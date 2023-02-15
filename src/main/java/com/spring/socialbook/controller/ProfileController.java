package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Profile;
import com.spring.socialbook.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("/posts")
    List<Profile> all(){
        System.out.println("Get all called");
        return profileRepository.findAll();
    }

    @PostMapping("/posts")
    Profile createUser(@RequestBody Profile profile){
        return profileRepository.save(profile);
    }

    @PutMapping("/post/{id}")
    Profile updateUser(@RequestBody Profile profile, @PathVariable Long id){
        return profileRepository.findById(id).map(post->{
            post.setFirstName(profile.getFirstName());
            post.setLastName(profile.getLastName());
            post.setEmail(profile.getEmail());
            post.setDob(profile.getDob());
            post.setGender(profile.getGender());
            return profileRepository.save(post);
        }).orElseGet(() ->{
            profile.setUserId(id);
            return profileRepository.save(profile);
        });
    }

    @DeleteMapping("/posts/{id}")
    void deleteUser(@PathVariable Long id) {profileRepository.deleteById(id);}

//    Single Item

    @GetMapping("/posts/{id}")
    Profile oneUser(@PathVariable Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.get();
    }
}
