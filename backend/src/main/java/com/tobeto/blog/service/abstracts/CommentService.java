package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.service.dtos.requests.comment.AddCommentRequest;
import com.tobeto.blog.service.dtos.requests.comment.UpdateCommentRequest;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentListResponse;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentResponse;

import java.util.List;

public interface CommentService {

    GetCommentResponse getById(int id);
    List<GetCommentListResponse> getAll();
    void add(AddCommentRequest addCommentRequest);
    void update(UpdateCommentRequest updateCommentRequest);
    void delete(int id);
}
