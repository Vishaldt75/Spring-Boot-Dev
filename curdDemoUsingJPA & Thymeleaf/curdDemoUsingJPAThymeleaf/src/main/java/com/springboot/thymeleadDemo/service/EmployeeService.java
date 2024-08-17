package com.springboot.thymeleadDemo.service;

import com.springboot.thymeleadDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theID);
    Employee save(Employee theEmployee);
    void deleteByID(int theID);
}
