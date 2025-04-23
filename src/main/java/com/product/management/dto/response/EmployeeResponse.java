package com.product.management.dto.response;

import com.product.management.constant.Authority;
import com.product.management.constant.Departments;
import com.product.management.constant.Positions;
import com.product.management.entity.Employees;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeResponse {
    private String employeeCode;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDate hireDate;
    private int salary;
    private Authority authority;
    private Positions positions;
    private Departments departments;

    public static EmployeeResponse ofMyProfile(Employees employees) {
        return EmployeeResponse.builder()
                .employeeCode(employees.getEmployeeCode())
                .name(employees.getName())
                .password(employees.getPassword())
                .email(employees.getEmail())
                .phone(employees.getPhone())
                .address(employees.getAddress())
                .hireDate(employees.getHiredDate())
                .salary(employees.getSalary())
                .authority(employees.getAuthority())
                .positions(employees.getPositions())
                .departments(employees.getDepartments())
                .build();
    }
}
