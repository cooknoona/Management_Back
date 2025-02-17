package com.product.management.entity;

import com.product.management.constant.Authority;
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

    @Column(nullable = false, length = 20)
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

    // 입사일
    @Column(nullable = false, updatable = false)
    private LocalDate hiredDate;

    // 프로그램 가입일
    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    @Column(nullable = true, length = 30)
    private int salary;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Positions positions;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Departments departments;
}
