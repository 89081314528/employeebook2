package ru.julia.employeebook2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julia.employeebook2.dto.EmployeeDto;
import ru.julia.employeebook2.dto.SalaryComparator;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    @Override
    public EmployeeDto getEmployeeWithMaxSalaryByDepartment(Integer departmentId) {
        // 1 вариант написания компаратора
        Comparator<EmployeeDto> comparator = new SalaryComparator();
        List<EmployeeDto> employees = employeeService.findAll();
        return employees.stream()
                .filter(employeeDto -> Objects.equals(employeeDto.getDepartmentId(), departmentId))
                .max(comparator)//здесь optional (в нем или сотрудник с мах зарплатой или null)
                .orElseThrow(); // здесь сотрудник или исключение если был null
    }

    @Override
    public EmployeeDto getEmployeeWithMinSalaryByDepartment(Integer departmentId) {
        // 2 вариант написания компаратора
        Comparator<EmployeeDto> comparator = Comparator.comparing(EmployeeDto::getSalary);
        List<EmployeeDto> employees = employeeService.findAll();
        return employees.stream()
                .filter(employeeDto -> Objects.equals(employeeDto.getDepartmentId(), departmentId))
                .min(comparator)
                .orElseThrow();
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartment(Integer departmentId) {
        List<EmployeeDto> employees = employeeService.findAll();
        return employees.stream()
                .filter(employeeDto -> Objects.equals(employeeDto.getDepartmentId(), departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesSortedByDepartment() {
        Comparator<EmployeeDto> comparator = Comparator.comparing(EmployeeDto::getDepartmentId);
        List<EmployeeDto> employees = employeeService.findAll();
        return employees.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
