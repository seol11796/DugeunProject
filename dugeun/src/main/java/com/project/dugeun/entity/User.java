package com.project.dugeun.entity;


import com.project.dugeun.dto.UserFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;



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

    //@Column(name="name",nullable = false,unique = true,length = 30)
    private String name; // 유저 이름

   // @Column(name="password")
    private String password;

    //@Column(name="external_id", unique = true)
    @Column(unique = true)
    private String externalId; // 카카오아이디

    //@Column(name="student_id")
    private String studentId; // 학번

    private String department; // 학과

    @Builder
    public User(String name, String externalId, String password, String studentId,
                String department){
        this.name = name;
        this.externalId = externalId;
        this.password = password;
        this.studentId = studentId;
        this.department = department;
    }

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = User.builder()
                .name(userFormDto.getName())
                .externalId(userFormDto.getExternalId())
                .studentId(userFormDto.getStudentId())
                .department(userFormDto.getDepartment())
                .password(passwordEncoder.encode(userFormDto.getPassword()))
                .build();
        return user;
    }

    }


