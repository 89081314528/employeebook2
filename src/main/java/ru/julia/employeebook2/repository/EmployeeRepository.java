package ru.julia.employeebook2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.employeebook2.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> getByFirstNameAndLastName(String firstName, String lastName);
}
