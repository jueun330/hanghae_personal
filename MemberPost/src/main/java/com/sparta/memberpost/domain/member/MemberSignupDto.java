package com.sparta.memberpost.domain.member;

import lombok.*;

import javax.validation.constraints.Pattern;



@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignupDto {
    @Pattern(regexp = "[a-zA-Z0-9]{4,12}", message="닉네임은 4-12글자의 알파벳과 숫자의 조합이어야 합니다.")
    private String username;

    @Pattern(regexp = "[a-z0-9]{4,32}", message ="비밀번호는 4~32글자의 알파벳 소문자와 숫자의 조합이어야 합니다.")
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
