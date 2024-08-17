package com.springboot.thymeleadDemo.dao;

import com.springboot.thymeleadDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByOrderByLastNameAsc();
}
