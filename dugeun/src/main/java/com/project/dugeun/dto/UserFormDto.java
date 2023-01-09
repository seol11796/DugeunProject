package com.project.dugeun.dto;

import com.project.dugeun.authority.UserAuthority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class UserFormDto {

    @NotBlank(message="아이디는 필수 입력 입니다.")
    private String userId;

    @NotEmpty(message = "카카오톡 ID 입력은 필수 입니다.")
    private String externalId;

    @NotEmpty(message = "학번 입력은 필수 입니다.")
    private String studentId;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    private UserAuthority userAuthority;

    @Builder
    public UserFormDto(String userId, String externalId, String studentId, String password, UserAuthority userAuthority) {
        this.userId = userId;
        this.externalId = externalId;
        this.studentId = studentId;
        this.password = password;
        this.userAuthority = userAuthority;
    }
}
