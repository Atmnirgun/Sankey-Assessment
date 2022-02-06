package com.sankey.backend.backend.services;

import com.sankey.backend.backend.dao.EmployeeDao;
import com.sankey.backend.backend.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.findById(id).get();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee savedEmployee = getEmployeeById(id);
        savedEmployee.setFirstName(employee.getFirstName());
        savedEmployee.setLastname(employee.getLastname());
        savedEmployee.setEmail(employee.getEmail());

        employeeDao.save(savedEmployee);
        return savedEmployee;
    }

    @Override
    public Boolean deleteEmployee(int id) {
        Employee savedEmployee = getEmployeeById(id);
        if (savedEmployee == null)
            return false;
        employeeDao.delete(savedEmployee);
        return true;
    }
}
