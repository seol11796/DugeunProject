package com.project.dugeun.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class UserFormDto {

    private String name;
    private String password;

    private String externalId;
    private Long studentId;




}
