package com.project.webtemplate.service;

import org.apache.commons.lang3.StringUtils;
import com.project.webtemplate.entities.User;
import com.project.webtemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository adminRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void addAdmin(User user) {
        String password = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        adminRepository.save(user);
    }

    public boolean logIn(String username, String password) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            User user = adminRepository.getUserByUsernameAndPassword(username, password);
            if (user != null) {
                return true;
            }
        }
        return false;
    }
}
