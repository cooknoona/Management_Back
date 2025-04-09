package com.product.management.dto.request;

import com.product.management.constant.Authority;
import com.product.management.constant.Departments;
import com.product.management.constant.Positions;
import com.product.management.entity.Employees;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
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

    /**
     * Request entity builder pattern for user registration */
    public Employees toJoin(PasswordEncoder passwordEncoder) {
        return Employees.builder()
                .name(name)
                .password(passwordEncoder.encode(password))
                .email(email)
                .phone(phone)
                .address(address)
                .hiredDate(hireDate)
                .positions(positions)
                .departments(departments)
                .build();
    }

    /**
     * Request entity builder pattern for modifying user info */
    public Employees toModify(PasswordEncoder passwordEncoder) {
        return Employees.builder()
                .name(name)
                .password(passwordEncoder.encode(password))
                .email(email)
                .phone(phone)
                .address(address)
                .hiredDate(hireDate)
                .salary(salary)
                .authority(authority)
                .positions(positions)
                .departments(departments)
                .build();
    }
}
