package com.project.webtemplate.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController
{
    @RequestMapping("/")
    public String index(Model model){
        String username = getPrincipal();
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", username);
        model.addAttribute("name", "Name");
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/error404")
    public String error404(){
        return "error404";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    private String getPrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}