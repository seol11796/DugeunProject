package com.project.dugeun.entity;

import com.project.dugeun.dto.UserFormDto;
import com.project.dugeun.entity.user.User;
import com.project.dugeun.repository.UserInfoRepository;
import com.project.dugeun.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource("classpath:application.properties")
public class UserInfoTest {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PersistenceContext
    EntityManager em;

    public User createUser(){
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setExternalId("seol11796");
        userFormDto.setName("seol");
        userFormDto.setStudentId("201811796");
        userFormDto.setPassword("1234");
        return User.createUser(userFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("유저 정보 엔티티 유저에 매핑 조회 테스트")
    public void findUserInfoAndUserTest(){
        User user = createUser();
        userRepository.save(user);

        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfoRepository.save(userInfo);

        em.flush();
        em.clear();

        UserInfo savedUserInfo = userInfoRepository.findById(userInfo.getUserInfoId())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals(savedUserInfo.getUser().getId(), user.getId());



    }


}
