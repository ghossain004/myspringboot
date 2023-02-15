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
public class SubComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subCommentId;
    private Long userId;
    private Long commentId;
    private Long postId;
    private String commentBody;
    private Integer commentCount;
    private Date createDate;
    private Time createTime;
    private Integer status;

    public SubComment(Long subCommentId, Long userId, Long commentId, Long postId, String commentBody, Integer commentCount, Date createDate, Time createTime, Integer status) {
        this.subCommentId = subCommentId;
        this.userId = userId;
        this.commentId = commentId;
        this.postId = postId;
        this.commentBody = commentBody;
        this.commentCount = commentCount;
        this.createDate = createDate;
        this.createTime = createTime;
        this.status = status;
    }
}
