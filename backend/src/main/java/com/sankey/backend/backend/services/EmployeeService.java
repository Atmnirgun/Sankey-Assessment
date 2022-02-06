package com.sankey.backend.backend.services;

import com.sankey.backend.backend.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public Employee updateEmployee(int id, Employee employee);
    public Boolean deleteEmployee(int id);
}
