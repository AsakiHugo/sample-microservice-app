package com.example.webui.controller;

import com.example.webui.ds.Departments;
import com.example.webui.ds.Employees;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/ui")
public class EmployeeController {
    @Value("http://localhost:8080/")
    private String backendUrl;
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/employees")
    public String listDepartments(Model model) {
        ResponseEntity<Employees> responseEntity = restTemplate
                .getForEntity(backendUrl + "employee/employees", Employees.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            model.addAttribute("employees", responseEntity.getBody().getEmployees());
            return "index";
        } else {
            throw new IllegalArgumentException(String
                    .format(
                            "Unable to list employees, received status %s",
                            responseEntity.getStatusCode()
                    ));
        }
    }
}
