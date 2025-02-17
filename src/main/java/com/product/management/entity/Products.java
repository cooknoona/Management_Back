package com.product.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String productCode;

    @Column(nullable = false, length = 200)
    private String productName;

    @Column(nullable = false, length = 20)
    private int quantity;

    @Column(nullable = true, length = 20)
    private Long price;

    // 제품의 위치, 예) A-10, A-2, B-3
    @Column(nullable = true, length = 10)
    private String location;

    // 상품의 길이
    @Column(nullable = true, length = 20)
    private String width;

    // 상품의 높이
    @Column(nullable = true, length = 20)
    private String height;

    // 상품의 무게
    @Column(nullable = true, length = 20)
    private String weight;

    @Column(nullable = false, length = 100)
    private LocalDate importedDate;

    @Column(nullable = false, length = 100)
    private LocalDate exportedDate;

    @Column(nullable = true, length = 100)
    private String importedBy;

    // Categories 는 최상위 엔티티
    // Categories = One to Many = Products
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    // Colours 는 중복된 값을 허용 하므로 Many to Many
    @ManyToMany
    @JoinTable(
        name = "product_colour",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "colour_id")
    )
    private List<Colours> colours = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "product_company",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Companies> companies = new ArrayList<>();
}
