package com.sparta.memberpost.repository;

import java.util.List;

import com.sparta.memberpost.domain.Comment;
import com.sparta.memberpost.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
}
