package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.GetPostListResponse;
import com.tobeto.blog.service.dtos.responses.post.GetPostResponse;

import java.util.List;

public interface PostService {

    GetPostResponse getById(int id);
    List<GetPostListResponse> getAll();
    void add(AddPostRequest addPostRequest);
    void update(UpdatePostRequest updatePostRequest);
    void delete(int id);
}