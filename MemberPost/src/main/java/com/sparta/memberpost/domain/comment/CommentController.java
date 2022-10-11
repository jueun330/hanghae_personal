package com.sparta.memberpost.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController{

    private final CommentService commentService;

    @PostMapping("/comment/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void commentSave(@PathVariable("postId") Long postId, CommentRequestDto commentRequestDto){
        commentService.save(postId, commentRequestDto);
    }

    @PutMapping("/comment/{commentId}")
    public void update(@PathVariable("commentId") Long commentId,
                       CommentResponseDto commentResponseDto){
        commentService.update(commentId, commentResponseDto);
    }


    @DeleteMapping("/comment/{commentId}")
    public void delete(@PathVariable("commentId") Long commentId) throws Exception {
        commentService.remove(commentId);
    }

}
