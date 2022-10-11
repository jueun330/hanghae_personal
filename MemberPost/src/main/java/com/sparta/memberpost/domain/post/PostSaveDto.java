package com.sparta.memberpost.domain.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class PostSaveDto {
    private String title;
    private String username;
    private String content;
    private String password;


    public Post toEntity() {
        return Post.builder().title(title).content(content).build();
    }

}
