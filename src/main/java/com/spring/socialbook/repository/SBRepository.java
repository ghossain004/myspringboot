package com.spring.socialbook.repository;

import com.spring.socialbook.entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SBRepository extends JpaRepository<Signup, Long> {
}
