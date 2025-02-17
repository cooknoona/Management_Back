package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "positions")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String positionCode;

    @Column(nullable = false, length = 50)
    private String positionName;

    @OneToMany(mappedBy = "positions")
    private List<Employees> users;
}
