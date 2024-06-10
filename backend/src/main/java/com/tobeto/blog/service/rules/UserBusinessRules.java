package com.tobeto.blog.service.rules;

import com.tobeto.blog.entity.concretes.User;
import com.tobeto.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.tobeto.blog.service.constants.Messages;
@Service
@AllArgsConstructor
public class UserBusinessRules {
    private final UserRepository userRepository;

    //DB içerisinde User id' ye sahip user olup olmama durumu kontrolü
    public User checkByUserId(int id){
        if(!(userRepository.existsById(id))){
            throw new RuntimeException(id + Messages.UserMessage.USER_NOT_FOUND);
        }
        return userRepository.findById(id).orElseThrow();
    }
}
