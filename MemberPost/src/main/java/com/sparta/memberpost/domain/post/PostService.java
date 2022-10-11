package com.sparta.memberpost.domain.post;

import java.util.List;

public interface PostService {

     void save(PostSaveDto postSaveDto);


    void update(Long id, PostSaveDto postSaveDto);


    void delete(Long id);


    PostInfoDto getPostInfo(Long id);

    List<PostInfoDto> findAll() ;

}
