package com.spring.socialbook.controller;

import com.spring.socialbook.entity.SubComment;
import com.spring.socialbook.repository.SubCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SubCommentController {
    @Autowired
    SubCommentRepository subCommentRepository;

    @GetMapping("/comment")
    List<SubComment> all(){
        System.out.println("Get all called");
        return subCommentRepository.findAll();
    }

    @PostMapping("/comment")
    SubComment newSubComment(@RequestBody SubComment subComment){
        subComment.setCreateTime(LocalTime.now());
        subComment.setCreateDate(LocalDate.now());
        return subCommentRepository.save(subComment);
    }

    @PutMapping("/comment/{id}")
    SubComment updateSubComment(@RequestBody SubComment subComment, @PathVariable Long id){
        return subCommentRepository.findById(id).map(post->{
            post.setCommentBody(subComment.getCommentBody());
            return subCommentRepository.save(post);
        }).orElseGet(() ->{
            subComment.setSubCommentId(id);
            return subCommentRepository.save(subComment);
        });
    }

    @DeleteMapping("/comment/{id}")
    void deleteSubComment(@PathVariable Long id) {subCommentRepository.deleteById(id);}

//    Single Item

    @GetMapping("/comment/{id}")
    SubComment oneSubComment(@PathVariable Long id) {
        Optional<SubComment> subComment = subCommentRepository.findById(id);
        return subComment.get();
    }
}
