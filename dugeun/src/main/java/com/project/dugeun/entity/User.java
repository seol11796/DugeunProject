package com.project.dugeun.entity;

import com.project.dugeun.dto.UserFormDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements UserDetails {

    @Id
    @Column(name="user_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 자동 생성되는 유저 id

    @Column(name="name",nullable = false,unique = true,length = 30)
    private String name; // 유저 이름

    @Column(name="password")
    private String password;

    @Column(name="kakao_id", unique = true)
    private String kakaoId; // 카카오아이디

    @Column(name="student_id")
    private Long studentId; // 학번

    @Column(name="role")
    private String role; // 유저 권한

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setName(userFormDto.getName());
        user.setKakaoId(userFormDto.getKakaoId());
        user.setStudentId(userFormDto.getStudentId());
        String password = passwordEncoder.encode(userFormDto.getPassword());
        user.setPassword(password);
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : role.split(",")) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

//    public String getName() {
//        return this.name;
//    }

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