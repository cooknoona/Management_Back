package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

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
    private LocalDateTime registeredAt;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Positions positions;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Departments departments;
}
