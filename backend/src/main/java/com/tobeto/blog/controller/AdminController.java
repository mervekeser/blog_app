package com.tobeto.blog.controller;

import com.tobeto.blog.service.abstracts.AdminService;
import com.tobeto.blog.service.dtos.requests.admin.AddAdminRequest;
import com.tobeto.blog.service.dtos.requests.admin.UpdateAdminRequest;
import com.tobeto.blog.service.dtos.responses.admin.GetAdminListResponse;
import com.tobeto.blog.service.dtos.responses.admin.GetAdminResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admins")
@AllArgsConstructor
@CrossOrigin
public class AdminController {
    private final AdminService adminService;

    @GetMapping("{id}")
    public GetAdminResponse getById(int id){
        return adminService.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetAdminListResponse> getAll(){
        return adminService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddAdminRequest addAdminRequest){
        adminService.add(addAdminRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAdminRequest updateAdminRequest){
        adminService.update(updateAdminRequest);
    }

    @DeleteMapping("{id}")
    public void delete(int id){
        adminService.delete(id);
    }
}
