package com.project.webtemplate.service;

import org.apache.commons.lang3.StringUtils;
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

    public boolean logIn(String username, String password) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            Admin admin = adminRepository.getAdminByUsernameAndPassword(username, password);
            if (admin != null) {
                return true;
            }
        }
        return false;
    }
}
