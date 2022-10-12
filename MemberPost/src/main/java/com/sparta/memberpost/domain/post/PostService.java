package com.sparta.memberpost.domain.post;

import java.util.List;

public interface PostService {

     Post save(PostSaveDto postSaveDto);



    Post update(Long id, PostSaveDto postSaveDto);


    Post delete(Long id);


    PostInfoDto getPostInfo(Long id);

    List<PostInfoDto> findAll() ;

}
