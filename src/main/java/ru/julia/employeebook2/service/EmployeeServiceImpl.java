package ru.julia.employeebook2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julia.employeebook2.dto.EmployeeDto;
import ru.julia.employeebook2.entity.Employee;
import ru.julia.employeebook2.exception.EmployeeNotFound;
import ru.julia.employeebook2.repository.EmployeeRepository;
import ru.julia.employeebook2.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public String add(String firstName, String lastName, Integer salary, Integer departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
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
    public EmployeeDto find(String firstName, String lastName) {
        List<Employee> employeeList = employeeRepository.getByFirstNameAndLastName(firstName, lastName);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFound();
        }
        Employee employee = employeeList.get(0);
       employeeList.contains(employee);
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
                employee.getSalary(), employee.getDepartmentId());
        return employeeDto;
    }
}
