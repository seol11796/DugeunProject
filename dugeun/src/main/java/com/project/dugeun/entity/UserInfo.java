package com.project.dugeun.entity;

import com.project.dugeun.constant.DrinkStatus;
import com.project.dugeun.constant.GenderStatus;
import com.project.dugeun.constant.PhysicalStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="USER_INFO")
public class UserInfo {

    @Id
    @Column(name="user_info_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userInfoId; // 유저정보 코드

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


    private int age; // 나이
    private GenderStatus gender; // 성별
    private String department; // 학과

    /*외모*/
    private String height; // 키
    private PhysicalStatus physical; // 체형

    /*음주가무*/
    private boolean smoke; // 흡연여무
    private DrinkStatus drink; // 음주선호

    /*취미*/
    // 일대다 매핑  , 한 사람당 취미 최대 3개

    /*성격*/
    // 일대다 매핑, 한 사람당 성격 최당 3개

    /*주소*/
    private String address;

    /*1순위*/
    private String firstPriority;
    /*2순위*/
    private String secondPriority;
    /*3순위*/
    private String thirdPriority;


    /*사진*/

    private String description; // 자기소개
}
