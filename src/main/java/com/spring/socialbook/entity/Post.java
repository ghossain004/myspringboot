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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private Long userId;
    private Integer likeCount;
    private Integer commentCount;
    private Integer shareCount;
    private Date createDate;
    private Time createTime;
    private Integer status;

    public Post(Long postId, Long userId, Integer likeCount, Integer commentCount, Integer shareCount, Date createDate, Time createTime, Integer status) {
        this.postId = postId;
        this.userId = userId;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
        this.createDate = createDate;
        this.createTime = createTime;
        this.status = status;
    }
}
