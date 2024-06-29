package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.entity.concretes.Post;
import com.tobeto.blog.service.dtos.requests.post.AddPostRequest;
import com.tobeto.blog.service.dtos.requests.post.UpdatePostRequest;
import com.tobeto.blog.service.dtos.responses.post.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    GetPostResponse getById(int id);
    List<GetPostListResponse> getAll();
    Page<Post> findAllPost(int page, int offset);
    void add(AddPostRequest addPostRequest);
    void update(UpdatePostRequest updatePostRequest);
    void delete(int id);


}
