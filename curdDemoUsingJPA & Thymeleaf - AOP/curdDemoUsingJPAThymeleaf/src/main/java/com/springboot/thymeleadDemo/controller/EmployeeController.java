package com.springboot.thymeleadDemo.controller;

import com.springboot.thymeleadDemo.entity.Employee;
import com.springboot.thymeleadDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        List<Employee> theEmployees=employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }
@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel)
{
    Employee theEmployee=new Employee();
    theModel.addAttribute("employee",theEmployee);
    return "employees/employee-form";
}
    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theID,Model theModel)
    {
        Employee theEmployee=employeeService.findByID(theID);
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theID)
    {
        employeeService.deleteByID(theID);
        return "redirect:/employees/list";
    }

}
