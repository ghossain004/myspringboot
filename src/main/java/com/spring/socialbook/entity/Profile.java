package com.spring.socialbook.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dob;
    private String gender;
    private String fatherName;
    private String motherName;
    private String userName;
    private String mobile;
    private String presentAddress;
    private String permanentAddress;
    private String religion;
    private String maritalStatus;

    public Profile(Long userId, String firstName, String lastName, String email, String password, String dob, String gender, String fatherName, String motherName, String userName, String mobile, String presentAddress, String permanentAddress, String religion, String maritalStatus, Integer status) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.userName = userName;
        this.mobile = mobile;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.religion = religion;
        this.maritalStatus = maritalStatus;
        this.status = status;
    }

    private Integer status
            ;
}
