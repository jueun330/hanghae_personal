package com.sparta.memberpost.domain.post;

import com.sparta.memberpost.domain.comment.CommentResponseDto;
import com.sparta.memberpost.domain.member.Member;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostInfoDto {

    private Long postId;
    private String title;
    private String content;
    private Member writer;

    private List<CommentResponseDto> comments;


    public PostInfoDto(Post post){
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writer = post.getWriter();
        this.comments = post.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
