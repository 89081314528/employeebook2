package ru.julia.employeebook2.entity;

import lombok.Data;
import java.util.Objects;

@Data
public class Employee {
    //?????GeneratedValue
    // сделать чтобы все сотрудники были в одном экземпляре
    // убрать айди
    // проверить контроллер
    // комментарии по дз 2.8
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer departmentId;

    public Employee(Integer employeeId, String firstName, String lastName, Integer salary, Integer departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String toString() {
        return firstName + " " + lastName + " " + salary + " " + departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, salary, departmentId);
    }
}
