package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    /** Category name - Pipe, Basket */
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "categories")
    private List<Products> products = new ArrayList<>();
}
