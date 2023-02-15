package com.spring.socialbook.repository;

import com.spring.socialbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
