package ru.julia.employeebook2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.employeebook2.dto.EmployeeDto;
import ru.julia.employeebook2.service.DepartmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/employeeWithMaxSalaryByDepartment")
    public EmployeeDto getEmployeeWithMaxSalaryByDepartment(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/employeeWithMinSalaryByDepartment")
    public EmployeeDto getEmployeeWithMinSalaryByDepartment(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/employeesByDepartment")
    public List<EmployeeDto> getEmployeesByDepartment(@RequestParam Integer departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping("/employeesSortedByDepartment")
    public List<EmployeeDto> getEmployeesSortedByDepartment() {
        return departmentService.getEmployeesSortedByDepartment();
    }
}
