package ru.julia.employeebook2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.julia.employeebook2.dto.EmployeeDto;
import ru.julia.employeebook2.entity.Employee;
import ru.julia.employeebook2.exception.EmployeeNotFound;
import ru.julia.employeebook2.repository.EmployeeRepository;
import ru.julia.employeebook2.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(value = "singleton") // дефолтный скоуп для всех бинов
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public String add(String firstName, String lastName, Integer salary) {
        Employee employee = Employee.builder()
                .firstName(firstName)
                .salary(salary)
                .lastName(lastName)
                .build();
        employeeRepository.save(employee);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан";
    }

    @Override
    public String remove(String firstName, String lastName) {
        List<Employee> employeeList = employeeRepository.getByFirstNameAndLastName(firstName, lastName);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFound();
        }
        Employee employee = employeeList.get(0);
        employeeRepository.delete(employee);
        return "Сотрудник " + firstName + " " + lastName + " удален";
    }

    @Override
    public String remove(Integer id) {
        employeeRepository.deleteById(id);
        return "Сотрудник с id " + id + " удален";
    }

    @Override
    public EmployeeDto find(String firstName, String lastName) {
        List<Employee> employeeList = employeeRepository.getByFirstNameAndLastName(firstName, lastName);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFound();
        }
        Employee employee = employeeList.get(0);

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getEmployeeId());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(e -> new EmployeeDto(
                        e.getEmployeeId(),
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary(),
                        e.getDepartment().getDeptId()))
                .collect(Collectors.toList());
    }
}
