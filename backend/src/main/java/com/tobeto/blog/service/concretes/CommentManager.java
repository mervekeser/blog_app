package com.tobeto.blog.service.concretes;

import com.tobeto.blog.entity.concretes.Comment;
import com.tobeto.blog.repository.CommentRepository;
import com.tobeto.blog.service.abstracts.CommentService;
import com.tobeto.blog.service.abstracts.PostService;
import com.tobeto.blog.service.constants.Messages;
import com.tobeto.blog.service.dtos.requests.comment.AddCommentRequest;
import com.tobeto.blog.service.dtos.requests.comment.UpdateCommentRequest;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentListResponse;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentResponse;
import com.tobeto.blog.service.mappers.CommentMapper;
import com.tobeto.blog.service.rules.CommentBusinessRules;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentManager implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentBusinessRules commentBusinessRules;
    private final CommentMapper commentMapper;

    @Override
    public GetCommentResponse getById(int id) {
        commentBusinessRules.checkByCommentId(id);
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(Messages.CommentMessages.COMMENT_NOT_FOUND + id));
        return commentMapper.commentToGetCommentResponse(comment);
    }

    @Override
    public List<GetCommentListResponse> getAll() {
        return commentRepository.findAll().stream()
                .map(commentMapper::commentToGetCommentListResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void add(AddCommentRequest addCommentRequest) {
        Comment comment = CommentMapper.INSTANCE.addCommentRequest(addCommentRequest);
        commentRepository.save(comment);

    }

    @Override
    public void update(UpdateCommentRequest updateCommentRequest) {
        commentBusinessRules.checkByCommentId(updateCommentRequest.getId());
        Comment comment = CommentMapper.INSTANCE.updateCommentRequest(updateCommentRequest);
        commentRepository.save(comment);
    }

    @Override
    public void delete(int id) {
        commentBusinessRules.checkByCommentId(id);
        commentRepository.deleteById(id);
    }
}
