package com.project.dugeun.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class UserFormDto {

    @NotBlank(message="이름(id)는 필수 입력 입니다.")
    private String name;

    @NotEmpty(message = "카카오톡 ID입력은 필수 입니다.")
    private String externalId;

    @NotEmpty(message = "학번 입력을 필수 입니다.")
    private String studentId;

    @NotEmpty(message = "학과를 선택해주세요")
    private String department;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @Builder
    public UserFormDto(String name, String externalId, String studentId, String password,
                       String department){
        this.name = name;
        this.externalId = externalId;
        this.studentId = studentId;
        this.password = password;
        this.department = department;
    }





}
