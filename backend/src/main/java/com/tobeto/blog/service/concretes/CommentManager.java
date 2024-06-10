package com.tobeto.blog.service.concretes;

import com.tobeto.blog.core.utilities.mappers.ModelMapperService;
import com.tobeto.blog.entity.concretes.Comment;
import com.tobeto.blog.repository.CommentRepository;
import com.tobeto.blog.service.abstracts.CommentService;
import com.tobeto.blog.service.dtos.requests.comment.AddCommentRequest;
import com.tobeto.blog.service.dtos.requests.comment.UpdateCommentRequest;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentListResponse;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentResponse;
import com.tobeto.blog.service.rules.CommentBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CommentManager implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentBusinessRules commentBusinessRules;
    private  ModelMapperService modelMapperService;

    @Override
    public GetCommentResponse getById(int id) {
        Comment comment = commentBusinessRules.checkByCommentId(id);
        GetCommentResponse commentResponse = modelMapperService.forResponse()
                .map(comment, GetCommentResponse.class);
        return commentResponse;
    }

    @Override
    public List<GetCommentListResponse> getAll() {
        List<Comment> commentList = commentRepository.findAll();

        List<GetCommentListResponse> commentListResponses = commentList.stream()
                .map(comment -> this.modelMapperService.forResponse()
                        .map(comment, GetCommentListResponse.class)).collect(Collectors.toList());
        return commentListResponses;
    }

    @Override
    public void add(AddCommentRequest addCommentRequest) {
        //commentBusinessRules.validateComment(addCommentRequest);
        Comment comment = this.modelMapperService.forRequest()
                .map(addCommentRequest, Comment.class);

        commentRepository.save(comment);

    }

    @Override
    public void update(UpdateCommentRequest updateCommentRequest) {
        commentBusinessRules.validateComment(updateCommentRequest);
        commentBusinessRules.checkByCommentId(updateCommentRequest.getId());
        Comment comment = this.modelMapperService.forRequest()
                .map(updateCommentRequest, Comment.class);

        commentRepository.save(comment);
    }

    @Override
    public void delete(int id) {
        commentBusinessRules.checkByCommentId(id);
        commentRepository.deleteById(id);
    }
}
