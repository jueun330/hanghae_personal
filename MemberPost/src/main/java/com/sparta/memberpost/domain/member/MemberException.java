package com.sparta.memberpost.domain.member;


import com.sparta.memberpost.global.BaseException;
import com.sparta.memberpost.global.BaseExceptionType;

public class MemberException extends BaseException {
    private BaseExceptionType exceptionType;


    public MemberException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}