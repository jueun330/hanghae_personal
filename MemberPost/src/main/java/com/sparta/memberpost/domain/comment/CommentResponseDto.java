package com.sparta.memberpost.domain.comment;


import com.sparta.memberpost.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long postId;//댓글이 달린 POST의 ID
    private Long commentId;//해당 댓글의 ID
    private String content;//내용 (삭제되었다면 "삭제된 댓글입니다 출력")
    private Member writer;//댓글 작성자에 대한 정보
     @Builder
    public CommentResponseDto(Comment comment){
        this.postId = comment.getPost().getId();
        this.commentId = comment.getId();
        this.content = comment.getContent();
        this.writer = comment.getWriter();
    }

}