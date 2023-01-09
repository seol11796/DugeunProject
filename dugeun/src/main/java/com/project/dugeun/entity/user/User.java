package com.project.dugeun.entity.user;


import com.project.dugeun.dto.UserFormDto;
import com.project.dugeun.entity.user.profile.DetailProfile;
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
    @Column(name="id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 자동 생성되는 유저 id

    @Column(name="user_id", unique = true)
    private String userId; // 유저 아이디

    @Column(name="name",nullable = false,unique = true,length = 30)
    private String name; // 유저 닉네임

    @Column(name="password")
    private String password;

    @Column(name="external_id", unique = true)
    private String externalId; // 카카오아이디

    @Column(name="student_id")
    private String studentId; // 학번


    @Embedded
    private DetailProfile detailProfile;

    @Builder
    public User(String name, String externalId, String password, String studentId
                ){
        this.name = name;
        this.externalId = externalId;
        this.password = password;
        this.studentId = studentId;
    }

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = User.builder()
                .name(userFormDto.getName())
                .externalId(userFormDto.getExternalId())
                .studentId(userFormDto.getStudentId())
                .password(passwordEncoder.encode(userFormDto.getPassword()))
                .build();
        return user;
    }

    }


