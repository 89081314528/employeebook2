package ru.julia.employeebook2.entity;

import lombok.Data;
import java.util.Objects;

@Data
public class Employee {
    // сделать чтобы все сотрудники были в одном экземпляре
    // проверить контроллер
    // комментарии по дз 2.8
    private String firstName;
    private String lastName;
    private Integer salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary);
    }

    public Employee(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String toString() {
        return firstName + " " + lastName + " " + salary;
    }


}
