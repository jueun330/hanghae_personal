package com.sparta.memberpost.domain.comment;


import com.sparta.memberpost.domain.member.MemberRepository;
import com.sparta.memberpost.domain.post.PostRepository;
import com.sparta.memberpost.global.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    private final PostRepository postRepository;


    @Override
    public void save(Long postId, CommentRequestDto commentRequestDto) {
        commentRepository.save(commentRequestDto.toEntity());
    }


    @Override
    @Transactional(readOnly = true)
    public Comment findById(Long id) throws Exception {
        return commentRepository.findById(id).orElseThrow(() -> new Exception("댓글이 없습니다."));
    }

    @Transactional
    @Override
    public void update(Long id, CommentResponseDto commentResponseDto) {

        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentException(CommentExceptionType.NOT_POUND_COMMENT));
        if(!comment.getWriter().getUsername().equals(SecurityUtil.getLoginUsername())){
            throw new CommentException(CommentExceptionType.NOT_AUTHORITY_UPDATE_COMMENT);
        }
        comment.update(commentResponseDto.getContent());
    }

    @Override
    public void remove(Long id) throws CommentException {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new CommentException(CommentExceptionType.NOT_POUND_COMMENT));

        if(!comment.getWriter().getUsername().equals(SecurityUtil.getLoginUsername())){
            throw new CommentException(CommentExceptionType.NOT_AUTHORITY_DELETE_COMMENT);
        }

        comment.remove();

    }
}