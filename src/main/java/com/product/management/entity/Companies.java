package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 100)
    private String email;

    @Column(nullable = true, length = 100)
    private String address;

    @Column(nullable = true, length = 100)
    private String phone;

    @Column(nullable = true, length = 100)
    private String bankName;

    @Column(nullable = true, length = 100)
    private String bankAccount;
}
