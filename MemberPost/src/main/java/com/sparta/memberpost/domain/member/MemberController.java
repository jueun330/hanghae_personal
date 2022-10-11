package com.sparta.memberpost.domain.member;

import com.sparta.memberpost.global.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse signUp(@Valid @RequestBody MemberSignupDto memberSignUpDto) throws Exception {
        memberService.signUp(memberSignUpDto);
        return new CommonResponse(memberSignUpDto);
    }


}
