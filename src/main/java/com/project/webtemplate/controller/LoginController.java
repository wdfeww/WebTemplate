package com.project.webtemplate.controller;

import com.project.webtemplate.entities.Admin;
import com.project.webtemplate.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public void addAdmin(@RequestBody Admin admin) {
        loginService.addAdmin(admin);
    }
}
