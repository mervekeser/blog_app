package com.tobeto.blog.service.concretes;

import com.tobeto.blog.core.utilities.mappers.ModelMapperService;
import com.tobeto.blog.entity.concretes.User;
import com.tobeto.blog.repository.UserRepository;
import com.tobeto.blog.service.abstracts.UserService;
import com.tobeto.blog.service.constants.Messages;
import com.tobeto.blog.service.dtos.requests.user.UpdateUserRequest;
import com.tobeto.blog.service.dtos.responses.user.GetUserListResponse;
import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;
import com.tobeto.blog.service.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(Messages.GeneralMessage.WRONG_INFORMATION));
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userBusinessRules.checkByUserId(id);
        GetUserResponse userResponse = modelMapperService.forResponse().map(user, GetUserResponse.class);
        return userResponse;
    }

    @Override
    public List<GetUserListResponse> getAll() {
        List<User> userList = userRepository.findAll();

        List<GetUserListResponse> userResponse = userList.stream()
                .map(user ->this.modelMapperService.forResponse()
                        .map(user, GetUserListResponse.class)).collect(Collectors.toList());


        return userResponse;
    }

    @Override
    public void add(User addUserRequest) {
        User user = this.modelMapperService.forRequest()
                .map(addUserRequest, User.class);

        user.setEmail(user.getEmail().trim().toLowerCase());

        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest()
                .map(updateUserRequest, User.class);

        user.setEmail(user.getEmail().trim().toLowerCase());
        //Şifreyi güncellerken passwordEncoder ile kripto olarak güncelleme işlemi
        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));

        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userBusinessRules.checkByUserId(id);
        userRepository.deleteById(id);
    }
}
