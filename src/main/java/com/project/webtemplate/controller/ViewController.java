package com.project.webtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController
{
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Username");
        model.addAttribute("name", "Name");
        return "index";
    }

    @RequestMapping("/error404")
    public String error404(){
        return "error404";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}