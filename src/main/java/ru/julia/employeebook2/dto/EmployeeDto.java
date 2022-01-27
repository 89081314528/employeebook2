package ru.julia.employeebook2.dto;

import java.util.UUID;

public class EmployeeDto {
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer departmentId;

    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public EmployeeDto(UUID employeeId, String firstName, String lastName, Integer salary, Integer departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public boolean equals(Object obj) {
        EmployeeDto objEmployeeDto = (EmployeeDto) obj;
        if ((this.employeeId == null && objEmployeeDto.employeeId != null) || (this.employeeId != null && objEmployeeDto.employeeId == null)
                || (this.firstName == null && objEmployeeDto.firstName != null) || (this.firstName != null && objEmployeeDto.firstName == null)
                || (this.lastName == null && objEmployeeDto.lastName != null) || (this.lastName != null && objEmployeeDto.lastName == null)
                || (this.salary == null && objEmployeeDto.salary != null) || (this.salary != null && objEmployeeDto.salary == null)
                || (this.departmentId == null && objEmployeeDto.salary != null) || (this.departmentId != null && objEmployeeDto.salary == null)
        ) {
            return false;
        }

        if (this.employeeId == null || (this.employeeId.equals(objEmployeeDto.employeeId))
                && (this.firstName == null || this.firstName.equals(objEmployeeDto.firstName))
                && (this.lastName == null || this.lastName.equals(objEmployeeDto.lastName))
                && (this.salary == null || this.salary.equals(objEmployeeDto.salary))
                && (this.departmentId == null || this.departmentId.equals(objEmployeeDto.departmentId))) {
            return true;
        }
        return false;
//        Objects.equals()
    }

//    public int hashCode() {
//        Objects.hash()
//    }

}
