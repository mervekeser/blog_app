package com.tobeto.blog.service.rules;

import com.tobeto.blog.entity.concretes.Comment;
import com.tobeto.blog.enums.BadWord;
import com.tobeto.blog.repository.CommentRepository;
import com.tobeto.blog.service.constants.Messages;
import com.tobeto.blog.service.dtos.requests.comment.CommentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CommentBusinessRules {

    private final CommentRepository commentRepository;

    public void validateComment(CommentRequest comment) {
        if (comment.getContent().length() < 3 || comment.getContent().length() > 500) {
            throw new RuntimeException("Yorum uzunluğu geçerli değil.");
        }

        // Kötü söz kontrolü
        BadWord.checkForProfanity(comment.getContent());

    }

    public Comment checkByCommentId(int id){
        if(!(commentRepository.existsById(id))){
            throw new RuntimeException(id + Messages.CommentMessages.COMMENT_NOT_FOUND);
        }
        return commentRepository.findById(id).orElseThrow();
    }


}
