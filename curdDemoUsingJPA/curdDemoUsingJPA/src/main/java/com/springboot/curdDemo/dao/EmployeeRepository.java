package com.springboot.curdDemo.dao;

import com.springboot.curdDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
