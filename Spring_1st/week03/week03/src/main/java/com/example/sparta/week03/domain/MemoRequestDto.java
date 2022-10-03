package com.example.sparta.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemoRequestDto {
    private String title;
    private String username;

    private String contents;

    private Integer password;


    public MemoRequestDto(String title, String username, Integer password, String contents){
        this.username = username;
        this.title = title;
        this.password = password;
        this.contents = contents;
    }
}