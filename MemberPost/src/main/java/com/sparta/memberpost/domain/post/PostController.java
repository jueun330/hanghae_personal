package com.sparta.memberpost.domain.post;

import com.sparta.memberpost.global.response.ListResponse;
import com.sparta.memberpost.global.response.ResponseService;
import com.sparta.memberpost.global.response.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private  final ResponseService responseService;


    /**
     * 게시글 저장
     *
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public SingleResponse<Post> save(@Valid @ModelAttribute @RequestBody PostSaveDto postSaveDto){
        return responseService.getSingleResponse(postService.save(postSaveDto));

    }

    /**
     * 게시글 수정
     */
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/post/{postId}")
    public SingleResponse<PostSaveDto> update(@PathVariable("postId") Long postId,
                       @ModelAttribute PostSaveDto postSaveDto){
        postService.update(postId, postSaveDto);
        return responseService.getSingleResponse(postSaveDto);
    }

    /**
     * 게시글 삭제
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/post/{postId}")
    public SingleResponse<String> delete(@PathVariable("postId") Long postId){
        postService.delete(postId);
        return responseService.getSingleResponse("delete success");
    }


    /**
     * 게시글 조회
     */
    @GetMapping("/post/{postId}")
    public SingleResponse<PostInfoDto> getInfo(@PathVariable("postId") Long postId){
        return responseService.getSingleResponse(postService.getPostInfo(postId));
    }

    @GetMapping("/post/list")
    public ListResponse<PostInfoDto> getInfoList(){
        return responseService.getListResponse(postService.findAll());
    }
}