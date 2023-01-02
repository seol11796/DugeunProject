package com.project.dugeun.entity;

import com.project.dugeun.dto.UserFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(name="user_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 자동 생성되는 유저 id

    @Column(name="name",nullable = false,unique = true,length = 30)
    private String name; // 유저 이름

    @Column(name="password")
    private String password;

    @Column(name="external_id", unique = true)
    private String externalId; // 카카오아이디

    @Column(name="student_id")
    private Long studentId; // 학번

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setName(userFormDto.getName());
        user.setExternalId(userFormDto.getExternalId());
        userFormDto.setStudentId(userFormDto.getStudentId());
        String password = passwordEncoder.encode(userFormDto.getPassword());
        user.setPassword(password);
        return user;
    }

//    @Column(name="department", nullable = false)
//    private String department; // 유저 학과

//    @Lob
//    @Column(name="description", nullable = false)
//    private String description; // 유저 자기소개
}