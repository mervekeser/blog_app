package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.entity.concretes.User;
import com.tobeto.blog.service.dtos.requests.user.UpdateUserRequest;
import com.tobeto.blog.service.dtos.responses.user.GetUserListResponse;
import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;

import java.util.List;

public interface UserService {
    User getByEmail(String email);
    GetUserResponse getById(int id);
    List<GetUserListResponse> getAll();
    void add(User addUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
}
