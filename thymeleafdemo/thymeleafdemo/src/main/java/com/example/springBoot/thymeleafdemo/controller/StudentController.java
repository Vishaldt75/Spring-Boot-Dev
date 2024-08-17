package com.example.springBoot.thymeleafdemo.controller;

import com.example.springBoot.thymeleafdemo.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;
    @GetMapping("showStudentForm")
    public String showForm(Model model)
    {
        //Create New Student object
        Student theStudent= new Student();
        //add student to object
        model.addAttribute("student",theStudent);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        System.out.println("theStudent : "+theStudent.getFirstName() +" "+theStudent.getLastName());
        return "student-confirmation";
    }
}
