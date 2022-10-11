package com.sparta.memberpost.domain.comment;


public interface CommentService {

    void save(Long id, CommentRequestDto commentRequestDto);

    Comment findById(Long id) throws Exception;

    void update(Long id, CommentResponseDto commentResponseDto);

    void remove(Long id) throws Exception;
}