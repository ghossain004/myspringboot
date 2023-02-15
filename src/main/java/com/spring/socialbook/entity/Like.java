package com.spring.socialbook.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeId;
    private Long postId;
    private Long userId;
    private Integer likeCount;
    private Integer status;

    public Like(Long likeId, Long postId, Long userId, Integer likeCount, Integer status) {
        this.likeId = likeId;
        this.postId = postId;
        this.userId = userId;
        this.likeCount = likeCount;
        this.status = status;
    }
}