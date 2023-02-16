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
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;
    private Long userId;
    private String messageBody;
    private String firstName;
    private String lastName;
    private LocalDate createDate;
    private LocalTime createTime;
    private Integer status;

    public Message(Long messageId, Long userId, String messageBody, String firstName, String lastName, LocalDate createDate, LocalTime createTime, Integer status) {
        this.messageId = messageId;
        this.userId = userId;
        this.messageBody = messageBody;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createDate = createDate;
        this.createTime = createTime;
        this.status = status;
    }
}
