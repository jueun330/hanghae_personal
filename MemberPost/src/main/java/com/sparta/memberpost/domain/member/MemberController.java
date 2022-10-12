package com.sparta.memberpost.domain.member;

import com.sparta.memberpost.global.response.ResponseService;
import com.sparta.memberpost.global.response.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;

    private final LoginService loginService;
    private final ResponseService responseService;

    @PostMapping("/signup")

    public SingleResponse<Member> signUp(@RequestBody @Valid MemberSignupDto memberSignUpDto) throws Exception {
        return responseService.getSingleResponse(memberService.signUp(memberSignUpDto));
    }

    @PostMapping("/login")
    public SingleResponse<MemberInfoDto> login(@RequestBody MemberInfoDto memberInfoDto) throws Exception {
        return responseService.getSingleResponse(memberInfoDto);
    }

}
