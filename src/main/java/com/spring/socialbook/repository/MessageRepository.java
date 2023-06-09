package com.spring.socialbook.repository;

import com.spring.socialbook.entity.Message;
import com.spring.socialbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
//    @Query("select concat(first_name, ' ', last_name) as user_name from user u where user_id = ?")
//    List<User> findByName(String user_name);
}
