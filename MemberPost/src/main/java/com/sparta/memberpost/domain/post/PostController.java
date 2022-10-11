package com.sparta.memberpost.domain.post;

import com.sparta.memberpost.global.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    /**
     * 게시글 저장
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public void save(@Valid @ModelAttribute PostSaveDto postSaveDto){
        postService.save(postSaveDto);
    }

    /**
     * 게시글 수정
     */
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/post/{postId}")
    public void update(@PathVariable("postId") Long postId,
                       @ModelAttribute PostSaveDto postSaveDto){


        postService.update(postId, postSaveDto);
    }

    /**
     * 게시글 삭제
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/post/{postId}")
    public void delete(@PathVariable("postId") Long postId){
        postService.delete(postId);
    }


    /**
     * 게시글 조회
     */
    @GetMapping("/post/{postId}")
    public CommonResponse getInfo(@PathVariable("postId") Long postId){
        return new CommonResponse(postService.getPostInfo(postId));
    }

    @GetMapping("/post/list")
    public CommonResponse.ofList getInfoList(){
        List<PostInfoDto> postInfoDtoList = postService.findAll();
        return new CommonResponse.ofList(postInfoDtoList);
    }




}