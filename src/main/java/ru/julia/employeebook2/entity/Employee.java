package ru.julia.employeebook2.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emps2")
@Data
@Builder
public class Employee {

    @Column(name = "emp_id")
    @Id
    @GeneratedValue
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "salary")
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public Employee(){};

    public String toString() {
        return firstName + " " + lastName + " " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if (employeeId == null) {
            return false;
        }
        return Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return 42;
    }

    //у энтити хэш код должен возвращать 42
    //у энтити equals должен возвращать false, если id = null/ если id не равен null, equals должен возвращать
    // сравнение с айди другой сущности
}
