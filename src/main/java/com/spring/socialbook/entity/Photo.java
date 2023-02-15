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
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photoId;
    private Long userId;
    private Long postId;
    private Integer likeCount;
    private Integer commentCount;
    private Integer shareCount;
    private Date createDate;
    private Time createTime;
    private Integer status;
}
