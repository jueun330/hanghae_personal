package com.sparta.memberpost.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void signUp(MemberSignupDto memberSignUpDto) throws Exception {
        Member member = memberSignUpDto.toEntity();
        member.encodePassword(passwordEncoder);
        if(memberRepository.findByUsername(memberSignUpDto.getUsername()).isPresent()){
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USERNAME);
        }

        memberRepository.save(member);
    }
}