package ru.julia.employeebook2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.julia.employeebook2.entity.Employee;
import ru.julia.employeebook2.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public String add(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName,
                    @RequestParam Integer salary, @RequestParam Integer departmentId) {
        return employeeService.add(id, firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/findAll")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}
