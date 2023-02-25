package com.javatechie.controller;

import com.javatechie.dto.Employee;
import com.javatechie.producer.EmployeePublisher;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeController {


    private EmployeePublisher employeePublisher;

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee) {
        employeePublisher.publishEmployeeInfo(employee);
        return "Employee info published ";
    }
}
