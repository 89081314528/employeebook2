package ru.julia.employeebook2.service;

import ru.julia.employeebook2.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    String add (String firstName, String lastName, Integer salary);
    String remove (String firstName, String lastName);
    String remove (Integer id);
    EmployeeDto find (String firstName, String lastName);
    List<EmployeeDto> findAll();

}
