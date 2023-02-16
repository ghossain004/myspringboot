package com.spring.socialbook.controller;

import com.spring.socialbook.entity.Message;
import com.spring.socialbook.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class MessageController {
    @Autowired
    MessageRepository repository;

    @GetMapping("/messages")
    List<Message> all(){
        System.out.println("Get all called");
        return repository.findAll();
    }

    @PostMapping("/messages")
    Message newPost(@RequestBody Message message){
        message.setCreateTime(LocalTime.now());
        message.setCreateDate(LocalDate.now());
        return repository.save(message);
    }

    @PutMapping("/messages/{id}")
    Message updateUser(@RequestBody Message message, @PathVariable Long id){
        return repository.findById(id).map(post->{
            post.setFirstName(message.getFirstName());
            post.setLastName(message.getLastName());
            post.setMessageBody(message.getMessageBody());
            return repository.save(post);
        }).orElseGet(() ->{
            message.setUserId(id);
            return repository.save(message);
        });
    }

    @DeleteMapping("/messages/{id}")
    void deleteUser(@PathVariable Long id) {repository.deleteById(id);}

//    Single Item

    @GetMapping("/messages/{id}")
    Message oneUser(@PathVariable Long id) {
        Optional<Message> message = repository.findById(id);
        return message.get();
    }
}
