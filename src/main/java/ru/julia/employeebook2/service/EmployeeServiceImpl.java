package ru.julia.employeebook2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julia.employeebook2.dto.FirstNameAndLastName;
import ru.julia.employeebook2.entity.Employee;
import ru.julia.employeebook2.exception.EmployeeNotFound;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    Map<FirstNameAndLastName, Employee> employees = new HashMap<>();

    @Override
    public String add(Integer id, String firstName, String lastName, Integer salary, Integer departmentId) {
        Employee employee = new Employee(id, firstName, lastName, salary, departmentId);
        FirstNameAndLastName firstNameAndLastName = new FirstNameAndLastName(firstName, lastName);
        employees.put(firstNameAndLastName, employee);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан";
    }

    @Override
    public String remove(String firstName, String lastName) {
        FirstNameAndLastName firstNameAndLastName = new FirstNameAndLastName(firstName, lastName);
        if (!employees.containsKey(firstNameAndLastName)) {
            throw new EmployeeNotFound();
        }
        employees.remove(firstNameAndLastName);
        return "Сотрудник " + firstName + " " + lastName + " удален";
    }

    @Override
    public Employee find(String firstName, String lastName) {
        FirstNameAndLastName firstNameAndLastName = new FirstNameAndLastName(firstName, lastName);
        if (!employees.containsKey(firstNameAndLastName)) {
            throw new EmployeeNotFound();
        }
        return employees.get(firstNameAndLastName);

    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
