package com.product.management.entity;

import com.product.management.constant.Authority;
import com.product.management.constant.Departments;
import com.product.management.constant.Positions;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long id;

    @Column(nullable = true, length = 20)
    private String employeeCode;

    @Column(nullable = false, unique = false, length = 20)
    private String name;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, unique = true, length = 50)
    private String phone;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, updatable = false)
    private LocalDate hiredDate;

    /** When you join the programme */
    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    @Column(nullable = true, length = 30)
    private int salary;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Enumerated(EnumType.STRING)
    private Departments departments;

    @Enumerated(EnumType.STRING)
    private Positions positions;
}
