package com.tobeto.blog.service.rules;

import com.tobeto.blog.entity.concretes.Admin;
import com.tobeto.blog.repository.AdminRepository;
import com.tobeto.blog.service.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminBusinessRules {
    private final AdminRepository adminRepository;

    public Admin checkByAdminId(int id){
        if(!(adminRepository.existsById(id))){
            throw new RuntimeException(id + Messages.AdminMessage.ADMIN_NOT_FOUND);
        }
        return adminRepository.findById(id).orElseThrow();
    }
}
