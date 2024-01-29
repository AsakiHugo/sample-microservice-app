package com.example.employeeservice.Controller;

import com.example.employeeservice.dao.EmployeeDao;
import com.example.employeeservice.ds.Employees;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeDao employeeDao;

    @GetMapping("/employees")
    public Employees listDepartments() {
        return new Employees(employeeDao.findAll().spliterator());
    }
}
