package com.sparta.memberpost.domain.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberInfoDto {
    private String username;
    private String password;

    @Builder
    public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .build();
    }
}
