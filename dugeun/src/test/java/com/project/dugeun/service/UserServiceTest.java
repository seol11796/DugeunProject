package com.project.dugeun.service;


import com.project.dugeun.dto.UserFormDto;
import com.project.dugeun.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(){
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setName("james");
        userFormDto.setExternalId("james123");
        userFormDto.setStudentId("201811796");
        userFormDto.setPassword("1234");
        return User.createUser(userFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트트")
    public void saveUserTest(){
        User user = createUser();
        User savedUser = userService.saveUser(user);

        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getExternalId(),savedUser.getExternalId());
        assertEquals(user.getStudentId(), savedUser.getStudentId());
        assertEquals(user.getPassword(), savedUser.getPassword());
    }
}

