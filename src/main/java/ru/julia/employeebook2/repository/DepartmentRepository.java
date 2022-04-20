package ru.julia.employeebook2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.employeebook2.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
