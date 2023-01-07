package com.project.dugeun.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFormDto {

    private String name;
    private String password;

    private String kakaoId;
    private Long studentId;
}
