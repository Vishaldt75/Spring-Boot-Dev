package com.springboot.curdDemo.service;

import com.springboot.curdDemo.dao.EmployeeRepository;
import com.springboot.curdDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
{
    employeeRepository=theEmployeeRepository;
}
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByID(int theID) {
        Optional<Employee> result = employeeRepository.findById(theID);
        Employee theEmployee=null;
        if(result.isPresent())
        {
            theEmployee=result.get();
        }
        else
        {
            throw  new RuntimeException("Did not Find Employee : "+theID);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteByID(int theID) {
        employeeRepository.deleteById(theID);
    }
}
