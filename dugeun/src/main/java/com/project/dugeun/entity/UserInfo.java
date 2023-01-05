package com.project.dugeun.entity;

import com.project.dugeun.constant.DrinkStatus;
import com.project.dugeun.constant.GenderStatus;
import com.project.dugeun.constant.PhysicalStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class UserInfo {

    private Long id; // 유저정보 코드

    private int age; // 나이
    private GenderStatus gender; // 성별
    private String department; // 학과

    private String height; // 키
    private PhysicalStatus physical; // 체형

    private boolean smoke;
    private DrinkStatus drink;


    private String description; // 자기소개
}
