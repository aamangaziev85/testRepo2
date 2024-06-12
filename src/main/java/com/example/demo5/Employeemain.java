package com.example.demo5;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employeemain {
    private String name;
    private List<Employee> employeeList;
    private int pinCode;
}
