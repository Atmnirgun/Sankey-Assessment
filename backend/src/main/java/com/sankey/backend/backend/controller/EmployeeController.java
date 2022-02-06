package com.sankey.backend.backend.controller;

import com.sankey.backend.backend.dto.EmployeeDTO;
import com.sankey.backend.backend.entities.Employee;
import com.sankey.backend.backend.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/employee")
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = modelMapper.map(employeeDTO,Employee.class);
        Employee savedEmployee = employeeService.createEmployee(newEmployee);

        EmployeeDTO savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDTO.class);
        return new ResponseEntity(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity getAllEmplyees(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        System.out.println(employeeList);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for(Employee employee : employeeList){
            employeeDTOList.add(modelMapper.map(employee, EmployeeDTO.class));
        }
        return new ResponseEntity(employeeDTOList, HttpStatus.OK);

    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity getEmployeeById(@PathVariable(name="id") int id){
        Employee savedEmployee = employeeService.getEmployeeById(id);

        EmployeeDTO savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDTO.class);
        return new ResponseEntity(savedEmployeeDto,HttpStatus.OK);
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable(name = "id") int id, @RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = modelMapper.map(employeeDTO,Employee.class);

        Employee updatedEmployee = employeeService.updateEmployee(id,newEmployee);
        EmployeeDTO updatedEmployeeDto = modelMapper.map(updatedEmployee,EmployeeDTO.class);

        return new ResponseEntity(updatedEmployeeDto,HttpStatus.OK);

    }

    @DeleteMapping(value = "employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "id") int id){
        Boolean isDeleted = employeeService.deleteEmployee(id);
        if(isDeleted)
            return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
        else
            return new ResponseEntity("No Employee Found.",HttpStatus.OK);
    }
}
