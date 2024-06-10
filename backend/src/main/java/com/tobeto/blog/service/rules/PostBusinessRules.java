package com.tobeto.blog.service.rules;

import com.tobeto.blog.entity.concretes.Post;
import com.tobeto.blog.repository.PostRepository;
import com.tobeto.blog.service.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostBusinessRules {
    private final PostRepository postRepository;

    public Post checkByPostId(int id){
        if(!(postRepository.existsById(id))){
            throw new RuntimeException(id + Messages.PostMessages.POST_NOT_FOUND);
        }
        return postRepository.findById(id).orElseThrow();
    }
}
