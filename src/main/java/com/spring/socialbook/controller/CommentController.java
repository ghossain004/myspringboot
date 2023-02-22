package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Comment;
import com.spring.socialbook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    List<Comment> all(){
        System.out.println("Get all called");
        return commentRepository.findAll();
    }

    @PostMapping("/comments")
    Comment newComment(@RequestBody Comment comment){
        comment.setCreateTime(LocalTime.now());
        comment.setCreateDate(LocalDate.now());
        return commentRepository.save(comment);
    }

    @PutMapping("/comments/{id}")
    Comment updateComment(@RequestBody Comment comment, @PathVariable Long id){
        return commentRepository.findById(id).map(post->{
            post.setCommentBody(comment.getCommentBody());
            return commentRepository.save(post);
        }).orElseGet(() ->{
//            comment.setUserId(id);
            return commentRepository.save(comment);
        });
    }

    @DeleteMapping("/comments/{id}")
    void deleteUser(@PathVariable Long id) {commentRepository.deleteById(id);}

//    Single Item

    @GetMapping("/comments/{id}")
    Comment oneComment(@PathVariable Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.get();
    }
}
