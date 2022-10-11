package com.sparta.memberpost.domain.comment;


import com.sparta.memberpost.domain.member.Member;
import com.sparta.memberpost.domain.member.MemberSignupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentRequestDto {

    private Long postId;//댓글이 달린 POST의 ID
    private Long commentId;//해당 댓글의 ID
    private String content;//내용 (삭제되었다면 "삭제된 댓글입니다 출력")
    private Member writer;//댓글 작성자에 대한 정보
    @Builder
    public CommentRequestDto(Comment comment){
        this.postId = comment.getPost().getId();
        this.commentId = comment.getId();

        this.content = comment.getContent();
        this.writer = new MemberSignupDto(comment.getWriter()).toEntity();
    }

    public Comment toEntity(){
        return Comment.builder().content(content).writer(writer).build();
    }

}
