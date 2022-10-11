package com.sparta.memberpost.domain.post;

import com.sparta.memberpost.domain.member.MemberException;
import com.sparta.memberpost.domain.member.MemberExceptionType;
import com.sparta.memberpost.domain.member.MemberRepository;
import com.sparta.memberpost.global.CommonResponse;
import com.sparta.memberpost.global.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.sparta.memberpost.domain.post.PostExceptionType.POST_NOT_POUND;


@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private CommonResponse commonResponse;

    @Override
    public void save(PostSaveDto postSaveDto) {
        Post post = postSaveDto.toEntity();

        post.confirmWriter(memberRepository.findByUsername(SecurityUtil.getLoginUsername())
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER)));

        postRepository.save(post);
    }

    @Override
    @Transactional
    public void update(Long id, PostSaveDto postSaveDto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new PostException(POST_NOT_POUND));

        checkAuthority(post, PostExceptionType.NOT_AUTHORITY_UPDATE_POST);

        post.updateTitle(postSaveDto.getTitle());
        post.updateContent(postSaveDto.getContent());

    }


    @Override
    public void delete(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() ->
                new PostException(POST_NOT_POUND));

        checkAuthority(post, PostExceptionType.NOT_AUTHORITY_DELETE_POST);

        postRepository.delete(post);

    }

    private void checkAuthority(Post post, PostExceptionType postExceptionType) {
        if (!post.getWriter().getUsername().equals(SecurityUtil.getLoginUsername()))
            throw new PostException(postExceptionType);
    }


    @Override
    public PostInfoDto getPostInfo(Long id) {
        /**
         * Post + MEMBER 조회 -> 쿼리 1번 발생
         *
         * 댓글&대댓글 리스트 조회 -> 쿼리 1번 발생(POST ID로 찾는 것이므로, IN쿼리가 아닌 일반 where문 발생)
         * (댓글과 대댓글 모두 Comment 클래스이므로, JPA는 구분할 방법이 없어서, 당연히 CommentList에 모두 나오는것이 맞다,
         * 가지고 온 것을 가지고 우리가 구분지어주어야 한다.)
         *
         * 댓글 작성자 정보 조회 -> 배치사이즈를 이용했기때문에 쿼리 1번 혹은 N/배치사이즈 만큼 발생
         *
         *
         */
        return new PostInfoDto(postRepository.findWithWriterById(id)
                .orElseThrow(() -> new PostException(POST_NOT_POUND)));

    }

    @Override
    public List<PostInfoDto> findAll() {
        List<Post> postList = postRepository.findAll();

        List<PostInfoDto> postInfoDtoList = postList.stream()
                .map(PostInfoDto::new).collect(
                        Collectors.toList());
        return postInfoDtoList;

    }
}