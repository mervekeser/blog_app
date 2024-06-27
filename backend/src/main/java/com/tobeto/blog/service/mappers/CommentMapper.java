package com.tobeto.blog.service.mappers;

import com.tobeto.blog.entity.concretes.Comment;
import com.tobeto.blog.service.dtos.requests.comment.AddCommentRequest;
import com.tobeto.blog.service.dtos.requests.comment.UpdateCommentRequest;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentListResponse;
import com.tobeto.blog.service.dtos.responses.comment.GetCommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    GetCommentResponse commentToGetCommentResponse(Comment comment);
    GetCommentListResponse commentToGetCommentListResponse(Comment comment);

   // @Mapping(source = "userId", target = "user")
    //@Mapping(source = "postId", target = "post")
    Comment addCommentRequest(AddCommentRequest addCommentRequest);

    Comment updateCommentRequest(UpdateCommentRequest updateCommentRequest);
}
