package com.tobeto.blog.service.mappers;

import com.tobeto.blog.entity.concretes.User;
import com.tobeto.blog.service.dtos.requests.user.AddUserRequest;
import com.tobeto.blog.service.dtos.requests.user.UpdateUserRequest;
import com.tobeto.blog.service.dtos.responses.user.GetUserListResponse;
import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    GetUserResponse getUserResponse(User user);
    GetUserListResponse getUserListResponse(User user);
   // User addUserRequest(AddUserRequest addUserRequest);
    //User updateUserRequest(UpdateUserRequest updateUserRequest);

}
