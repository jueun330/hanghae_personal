package com.sparta.memberpost.controller.request;


import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {
    @Pattern(regexp = "^((?=.*[a-z])(?=.*\\d){4,12})",message = "nickname은 4-12개의 영문자와 숫자로만 조합되어야합니다.")
    @NotNull
    @NotBlank(message = "nickname은 공백일 수 없습니다.")
    @Size(min = 4, max = 12, message = "nickname은 4-12글자의 영문자만 허용합니다.")
    private String nickname;
    @Pattern(regexp ="^((?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20})$", message = "패스워드는 무조건 영문, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.")
    @NotNull
    @NotBlank(message = "패스워드는 공백일 수 없습니다.")
    @Size(min = 8, max = 20, message = "패스워드는 8-20개의 문자만 허용합니다.")
    private String password;
    @NotNull
    @NotBlank
    private String passwordConfirm;


}
