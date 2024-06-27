package com.tobeto.blog.service.rules;

import com.tobeto.blog.entity.concretes.Comment;
import com.tobeto.blog.repository.CommentRepository;
import com.tobeto.blog.service.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CommentBusinessRules {

    private final CommentRepository commentRepository;


    public Comment checkByCommentId(int id){
        if(!(commentRepository.existsById(id))){
            throw new RuntimeException(id + Messages.CommentMessages.COMMENT_NOT_FOUND);
        }
        return commentRepository.findById(id).orElseThrow();
    }


}
