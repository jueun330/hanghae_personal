package com.sparta.memberpost.controller.response;

public class ErrorResponse {
    private String field;

    private String message;

    public ErrorResponse(String field, String message){
        this.field = field;
        this.message = message;
    }
}
