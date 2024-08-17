package com.springboot.curdDemo.dao;

import com.springboot.curdDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findByID(int theID);
    Employee save(Employee theEmployee);

    void deleteByID(int theID);
}
