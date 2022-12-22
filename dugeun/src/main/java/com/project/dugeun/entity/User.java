package com.project.dugeun.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="user")
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId; // 유저 id

    @Column(name="name",nullable = false,length = 30)
    private String userName; // 유저 이름

    @Column(name="age",nullable = false)
    private int age; // 유저 나이

    @Column(name="department", nullable = false)
    private String department; // 유저 학과

    @Lob
    @Column(name="description", nullable = false)
    private String description; // 유저 자기소개


}
