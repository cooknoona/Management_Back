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

    /** Where the location is like A-10, B-3, C-12 */
    @Column(nullable = true, length = 10)
    private String location;

    /** Width of the item /cm */
    @Column(nullable = true, length = 20)
    private String width;

    /** Height of the item /cm */
    @Column(nullable = true, length = 20)
    private String height;

    /** Weight of the item /kg */
    @Column(nullable = true, length = 20)
    private String weight;

    @Column(nullable = false, length = 100)
    private LocalDate importedDate;

    @Column(nullable = false, length = 100)
    private LocalDate exportedDate;

    @Column(nullable = true, length = 100)
    private String importedBy;

    /** Categories is the highest entity
     * Categories = One to Many = Products */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    /** Colours is allowed to have duplicated values so it's Many to Many */
    @Builder.Default
    @ManyToMany
    @JoinTable(
        name = "product_colour",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "colour_id")
    )
    private List<Colours> colours = new ArrayList<>();

    @Builder.Default
    @ManyToMany
    @JoinTable(
        name = "product_company",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Companies> companies = new ArrayList<>();
}
