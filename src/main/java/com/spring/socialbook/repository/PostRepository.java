package com.spring.socialbook.repository;

import com.spring.socialbook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
