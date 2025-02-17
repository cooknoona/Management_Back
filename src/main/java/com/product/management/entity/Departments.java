package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String departmentCode;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "departments")
    private List<Employees> employees;
}
