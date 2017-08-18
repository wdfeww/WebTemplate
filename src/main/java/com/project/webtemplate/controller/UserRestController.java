package com.project.webtemplate.controller;

import com.project.webtemplate.config.jwt.JwtTokenUtil;
import com.project.webtemplate.config.jwt.JwtUser;
import com.project.webtemplate.entities.User;
import com.project.webtemplate.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "user/new", method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute User user) {
        loginService.addAdmin(user);
        return "redirect:/admin";
    }

}
