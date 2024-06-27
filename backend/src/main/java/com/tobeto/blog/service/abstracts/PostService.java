package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.*;
import com.tobeto.blog.service.paging.PageInfo;
import com.tobeto.blog.service.responses.GetListResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    GetPostResponse getById(int id);
    List<GetPostListResponse> getAll();
    void add(AddPostRequest addPostRequest);
    void update(UpdatePostRequest updatePostRequest);
    void delete(int id);
}
