package com.example.webui.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String cubicleNo;

    public Employee() {
    }
}
