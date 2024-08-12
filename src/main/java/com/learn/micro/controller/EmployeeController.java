package com.learn.micro.controller;

import com.learn.micro.model.Employee;
import com.learn.micro.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping
    public List<Employee> getDetails(){
        LOGGER.info(">> Fetaching all Employee Details ::: ");
        return employeeRepository.findAll();
    }

    @PostMapping
    public  Employee getEmployeeDetails(@RequestBody Employee employee){
        LOGGER.info(">> Fetaching all Employee Details ::: {}",employee);
        return employeeRepository.save(employee);
    }

    @GetMapping("/department/{depid}")
    public List<Employee> getDepartmentIDDetails(@PathVariable Long depid){
        LOGGER.info(">> Fetaching Department ID Details ::: {}",depid);
        return employeeRepository.findByDepartmentid(depid);
    }

}
