package com.springboot.curdDemo.service;

import com.springboot.curdDemo.dao.EmployeeDAO;
import com.springboot.curdDemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
{
    employeeDAO=theEmployeeDAO;
}
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findByID(int theID) {
        return employeeDAO.findByID(theID);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteByID(int theID) {
    employeeDAO.deleteByID(theID);
    }
}
