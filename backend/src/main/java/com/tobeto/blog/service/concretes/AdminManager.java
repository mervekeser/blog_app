package com.tobeto.blog.service.concretes;

import com.tobeto.blog.core.utilities.mappers.ModelMapperService;
import com.tobeto.blog.entity.concretes.Admin;
import com.tobeto.blog.repository.AdminRepository;
import com.tobeto.blog.service.abstracts.AdminService;
import com.tobeto.blog.service.dtos.requests.admin.AddAdminRequest;
import com.tobeto.blog.service.dtos.requests.admin.UpdateAdminRequest;
import com.tobeto.blog.service.dtos.responses.admin.GetAdminListResponse;
import com.tobeto.blog.service.dtos.responses.admin.GetAdminResponse;
import com.tobeto.blog.service.rules.AdminBusinessRules;
import com.tobeto.blog.service.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminManager implements AdminService {
    private AdminRepository adminRepository;
    private ModelMapperService modelMapperService;
    private AdminBusinessRules adminBusinessRules;
    private UserBusinessRules userBusinessRules;


    @Override
    public void add(AddAdminRequest addAdminRequest) {
        //adminBusinessRules.checkByAdminId(addAdminRequest.getUserId());
        Admin admin = this.modelMapperService.forRequest()
                .map(addAdminRequest, Admin.class);
        adminRepository.save(admin);
    }

    @Override
    public void update(UpdateAdminRequest updateAdminRequest) {
        adminBusinessRules.checkByAdminId(updateAdminRequest.getId());
        userBusinessRules.checkByUserId(updateAdminRequest.getUserId());

        Admin admin = this.modelMapperService.forRequest()
                .map(updateAdminRequest, Admin.class);
        adminRepository.save(admin);
    }

    @Override
    public void delete(int id) {
        adminBusinessRules.checkByAdminId(id);
        adminRepository.deleteById(id);
    }

    @Override
    public GetAdminResponse getById(int id) {
        Admin admin = adminBusinessRules.checkByAdminId(id);
        GetAdminResponse adminResponse = modelMapperService.forResponse()
                .map(admin, GetAdminResponse.class);
        return adminResponse;
    }

    @Override
    public List<GetAdminListResponse> getAll() {
        List<Admin> adminList = adminRepository.findAll();

        List<GetAdminListResponse> adminListResponses = adminList.stream()
                .map(admin -> this.modelMapperService.forResponse()
                        .map(admin, GetAdminListResponse.class)).collect(Collectors.toList());
        return adminListResponses;
    }
}
