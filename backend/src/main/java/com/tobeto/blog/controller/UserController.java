package com.tobeto.blog.controller;

import com.tobeto.blog.service.abstracts.UserService;
import com.tobeto.blog.service.dtos.requests.user.UpdateUserRequest;
import com.tobeto.blog.service.dtos.responses.user.GetUserListResponse;
import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public GetUserResponse getById(int id){
        return userService.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetUserListResponse> getAll(){
        return userService.getAll();
    }

    @PutMapping()
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
        userService.update(updateUserRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/getUserInfo")
    public UserDetails getByEmail(String email){
        return userService.getByEmail(email);
    }
}
