package ru.julia.employeebook2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.employeebook2.dto.EmployeeDto;
import ru.julia.employeebook2.service.DepartmentService;
import ru.julia.employeebook2.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam Integer salary) {
        return employeeService.add(firstName, lastName, salary);
    }

    @GetMapping("/remove")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public EmployeeDto find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/findAll")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }
}
