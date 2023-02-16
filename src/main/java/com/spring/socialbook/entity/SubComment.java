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
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SubComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subCommentId;
    private Long userId;
    private Long commentId;
    private Long postId;
    private String userName;
    private String commentBody;
    private Integer commentCount;
    private LocalDate createDate;
    private LocalTime createTime;
    private Integer status;
}
