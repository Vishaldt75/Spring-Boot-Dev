package com.springboot.curdDemo.rest;

import com.springboot.curdDemo.entity.Employee;
import com.springboot.curdDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService=theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
     Employee theEmployee=employeeService.findByID(employeeId);
     if(theEmployee==null)
     {
         throw new RuntimeException("Employee ID not found : "+employeeId);
     }
     return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String DeleteEmployee(@PathVariable int employeeID)
    {
        Employee dbEmployee=employeeService.findByID(employeeID);
        if(dbEmployee==null)
        {
            throw new RuntimeException("Employee ID Not Found : "+employeeID);
        }
        employeeService.deleteByID(employeeID);

        return "Deleted Employee ID : "+employeeID;
    }
}
