package com.sparta.memberpost.global.response;

import lombok.Getter;

@Getter
public class SingleResponse<T> extends CommonResponse{
    T data;
}
