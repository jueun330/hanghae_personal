package com.sparta.memberpost.global;

public abstract class BaseException extends RuntimeException{
    public abstract BaseExceptionType getExceptionType();
}