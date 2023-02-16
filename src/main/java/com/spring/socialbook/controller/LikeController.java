package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Like;
import com.spring.socialbook.entity.Photo;
import com.spring.socialbook.repository.LikeRepository;
import com.spring.socialbook.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LikeController {
    @Autowired
    LikeRepository likeRepository;

    @GetMapping("/like")
    List<Like> all(){
        System.out.println("Get all called");
        return likeRepository.findAll();
    }

    @PostMapping("/like")
    Like newLike(@RequestBody Like like){
        return likeRepository.save(like);
    }

    @DeleteMapping("/like/{id}")
    void deleteSubComment(@PathVariable Long id) {likeRepository.deleteById(id);}

//    Single Item

    @GetMapping("/like/{id}")
    Like oneLike(@PathVariable Long id) {
        Optional<Like> like = likeRepository.findById(id);
        return like.get();
    }
}
