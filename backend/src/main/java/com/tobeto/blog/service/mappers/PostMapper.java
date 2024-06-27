package com.tobeto.blog.service.mappers;

import com.tobeto.blog.entity.concretes.Post;
import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.*;
import com.tobeto.blog.service.responses.GetListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    GetPostResponse postToGetPostResponse(Post post);
    GetPostListResponse postToGetPostListResponse(Post post);

    //@Mapping(source = "userId", target = "user")
    Post addPostRequest(AddPostRequest addPostRequest);

    Post updatePostRequest(UpdatePostRequest updatePostRequest);
}
