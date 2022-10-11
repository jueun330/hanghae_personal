package com.sparta.memberpost.domain.comment;


import com.sparta.memberpost.global.BaseException;
import com.sparta.memberpost.global.BaseExceptionType;

public class CommentException extends BaseException {

    private BaseExceptionType baseExceptionType;


    public CommentException(BaseExceptionType baseExceptionType) {
        this.baseExceptionType = baseExceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return this.baseExceptionType;
    }
}