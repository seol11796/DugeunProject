package com.project.dugeun.entity;

import com.project.dugeun.authority.UserAuthority;
import com.project.dugeun.dto.UserFormDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Builder
public class User implements UserDetails {

    @Column(name="id", unique = true)
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 자동 생성되는 유저 id

    @Column(name="user_id", unique = true)
    private String userId; // 유저 아이디

    @Column(name="name",nullable = false, unique = true, length = 30)
    private String name; // 유저 닉네임

    @Column(name="password")
    private String password;

    @Column(name="external_id", unique = true)
    private String externalId; // 카카오아이디

    @Column(name="student_id")
    private String studentId; // 학번

    private UserAuthority userAuthority;

    @Builder
    public User(Long id, String userId, String name, String password, String externalId, String studentId, UserAuthority userAuthority) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.externalId = externalId;
        this.studentId = studentId;
        this.userAuthority = userAuthority;
    }



//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> roles = new HashSet<>();
//        return roles;
////        List<GrantedAuthority> authorityList = new ArrayList<>();
////        authorityList.add(new SimpleGrantedAuthority("GENERAL"));
//
////        return authorityList;
//    }

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        return User.builder()
                .userId(userFormDto.getUserId())
                .externalId(userFormDto.getExternalId())
                .studentId(userFormDto.getStudentId())
                .password(passwordEncoder.encode(userFormDto.getPassword()))
                .userAuthority(userFormDto.getUserAuthority())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}