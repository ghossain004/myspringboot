package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Photo;
import com.spring.socialbook.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PhotoController {
    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("/photos")
    List<Photo> all(){
        System.out.println("Get all called");
        return photoRepository.findAll();
    }

    @PostMapping("/photos")
    Photo newPhoto(@RequestBody Photo photo){
        return photoRepository.save(photo);
    }

        @DeleteMapping("/photos/{id}")
    void deleteSubComment(@PathVariable Long id) {photoRepository.deleteById(id);}

//    Single Item

    @GetMapping("/photos/{id}")
    Photo onePhoto(@PathVariable Long id) {
        Optional<Photo> photo = photoRepository.findById(id);
        return photo.get();
    }
}
