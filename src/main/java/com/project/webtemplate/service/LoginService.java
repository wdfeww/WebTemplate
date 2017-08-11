package com.project.webtemplate.service;

import com.project.webtemplate.entities.Admin;
import com.project.webtemplate.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AdminRepository adminRepository;

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
