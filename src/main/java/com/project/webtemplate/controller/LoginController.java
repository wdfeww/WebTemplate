package com.project.webtemplate.controller;

import com.project.webtemplate.entities.Admin;
import com.project.webtemplate.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addAdmin(@RequestBody Admin admin) {
        loginService.addAdmin(admin);
    }
}
