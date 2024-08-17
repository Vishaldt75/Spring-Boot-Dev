package com.springboot.curdDemo.dao;

import com.springboot.curdDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJapImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJapImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findByID(int theID) {
        Employee theEmployee=entityManager.find(Employee.class,theID);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteByID(int theId) {
        Employee theEmployee=entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);

    }
}
