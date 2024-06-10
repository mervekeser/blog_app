package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.service.dtos.requests.admin.AddAdminRequest;
import com.tobeto.blog.service.dtos.requests.admin.UpdateAdminRequest;
import com.tobeto.blog.service.dtos.responses.admin.GetAdminListResponse;
import com.tobeto.blog.service.dtos.responses.admin.GetAdminResponse;

import java.util.List;

public interface AdminService {
    void add(AddAdminRequest addAdminRequest);
    void update(UpdateAdminRequest updateAdminRequest);
    void delete(int id);
    GetAdminResponse getById(int id);
    List<GetAdminListResponse> getAll();
}
