package com.spring.socialbook.repository;

import com.spring.socialbook.entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Signup, Long> {
}
