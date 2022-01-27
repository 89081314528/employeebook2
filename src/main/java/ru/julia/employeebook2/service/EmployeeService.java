package ru.julia.employeebook2.service;

import ru.julia.employeebook2.dto.EmployeeDto;

public interface EmployeeService {
    String add (String firstName, String lastName, Integer salary, Integer departmentId);
    String remove (String firstName, String lastName);
    EmployeeDto find (String firstName, String lastName);

}
