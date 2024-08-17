package com.example.springBoot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // controller method to show initial HTML form.
    @GetMapping("/showForm")
    public String showForm()
    {
        return "helloWorld-form";
    }
    //Controller method to show initial HTML form
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloWorldNew";
    }

    //Controller method to read form data to the model.
    @RequestMapping("/processFormNew")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {
        //Read Request Parameter from the HTML form
        String theName= request.getParameter("studentName");
        //convert the data to Caps
        theName=theName.toUpperCase();
        //Create Message
        String result="Yo! "+theName;
        //Add message to the model
        model.addAttribute("message",result);

        return "helloWorldNew";
    }
    @PostMapping("/processFormV2")
    public String processFormV2(@RequestParam("studentName") String theName, Model model)
    {
        //convert the data to Caps
        theName=theName.toUpperCase();
        //Create Message
        String result="Hello Friend ! "+theName;
        //Add message to the model
        model.addAttribute("message",result);

        return "helloWorldNew";
    }
}
