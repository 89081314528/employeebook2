package ru.julia.employeebook2.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "depts2")
@Data
public class Department {
    @Column(name = "dept_id")
    @Id
    @GeneratedValue
    private Integer deptId;
    @Column(name = "department")
    private String firstName;
    @OneToMany(mappedBy = "department")
    private Collection<Employee> employees;
}
