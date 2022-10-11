package com.sparta.memberpost.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Valid
@Data
@Builder
@Getter
@AllArgsConstructor
public class MemberSignupDto {
    @Size(min=4, max=12)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,12}&", message="닉네임은 4-12글자의 알파벳과 숫자의 조합이어야 합니다.")
    private String username;

    @Size(min=4, max=32)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{4,32}&", message ="비밀번호는 4~32글자의 알파벳 소문자와 숫자의 조합이어야 합니다.")
    private String password;


    private String checkedPassword;

    @Builder
    public MemberSignupDto(Member member){
        this.username = member.getUsername();
    }

    @Builder
    public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .build();
    }
}
