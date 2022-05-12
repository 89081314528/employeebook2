package ru.julia.employeebook2.dto;

import java.util.Comparator;

public class SalaryComparator implements Comparator<EmployeeDto> {
    @Override
    public int compare(EmployeeDto o1, EmployeeDto o2) {
        return o1.getSalary() - o2.getSalary();
    }

}
