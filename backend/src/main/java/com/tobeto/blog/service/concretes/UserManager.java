package com.tobeto.blog.service.concretes;

import com.tobeto.blog.entity.concretes.User;
import com.tobeto.blog.repository.UserRepository;
import com.tobeto.blog.service.abstracts.UserService;
import com.tobeto.blog.service.constants.Messages;
import com.tobeto.blog.service.dtos.requests.user.AddUserRequest;
import com.tobeto.blog.service.dtos.requests.user.UpdateUserRequest;
import com.tobeto.blog.service.dtos.responses.user.GetUserListResponse;
import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;
import com.tobeto.blog.service.mappers.UserMapper;
import com.tobeto.blog.service.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserManager  implements UserService{
    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(Messages.GeneralMessage.WRONG_INFORMATION));
    }

    @Override
    public GetUserResponse getById(int id) {
        userBusinessRules.checkByUserId(id);
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(Messages.UserMessage.USER_NOT_FOUND));
        return userMapper.getUserResponse(user);
    }

    @Override
    public List<GetUserListResponse> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::getUserListResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void add(User addUserRequest) {
        //userBusinessRules.checkByUserId(addUserRequest.getId());
         userRepository.save(addUserRequest);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        userBusinessRules.checkByUserId(updateUserRequest.getId());
        User user = userRepository.findById(updateUserRequest.getId())
                        .orElseThrow(()-> new RuntimeException(Messages.UserMessage.USER_NOT_FOUND));
        user.setPassword(updateUserRequest.getPassword());
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userBusinessRules.checkByUserId(id);
        userRepository.deleteById(id);
    }
}
