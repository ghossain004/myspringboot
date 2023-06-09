package com.spring.socialbook.repository;

import com.spring.socialbook.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
