package com.springProject.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage()
    {
        return "fancy-login";
    }
    @GetMapping("/")
    public String hello()
    {
        return "hello";
    }
    @GetMapping("/leaders")
    public String showLeaders()
    {
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystems()
    {
        return "systems";
    }

    @GetMapping("/access-denied")
    public String accessDenied()
    {
        return "access-denied";
    }
}
