package ru.julia.employeebook2.service;
import ru.julia.employeebook2.dto.EmployeeDto;
import java.util.List;

public interface DepartmentService {
    EmployeeDto getEmployeeWithMaxSalaryByDepartment(Integer departmentId);

    EmployeeDto getEmployeeWithMinSalaryByDepartment(Integer departmentId);

    List<EmployeeDto> getEmployeesByDepartment(Integer departmentId);

    List<EmployeeDto> getEmployeesSortedByDepartment();
}
