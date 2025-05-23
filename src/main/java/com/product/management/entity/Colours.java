package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colours")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Colours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="colour_id")
    private Long id;

    /** Colours name - Blue, Red, Yellow, Black */
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "colours")
    private List<Products> products = new ArrayList<>();
}
