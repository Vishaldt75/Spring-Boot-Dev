package com.springboot.curdDemo.service;

import com.springboot.curdDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findByID(int theID);
    Employee save(Employee theEmployee);
    void deleteByID(int theID);
}
