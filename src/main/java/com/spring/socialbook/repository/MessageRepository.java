package com.spring.socialbook.repository;

import com.spring.socialbook.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
