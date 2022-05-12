package ru.julia.employeebook2.service;

import ru.julia.employeebook2.entity.Employee;

import java.util.Collection;

public interface EmployeeService {
    String add (String firstName, String lastName, Integer salary);
    String remove (String firstName, String lastName);
    Employee find (String firstName, String lastName);
    Collection<Employee> findAll();
}
