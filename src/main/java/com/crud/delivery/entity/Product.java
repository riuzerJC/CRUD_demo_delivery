package com.crud.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name="name_product", nullable = false)
    private String nameProduct;

    @Column(name="product_description", nullable = false)
    private String productDescription;

    @Column(name="price_product", nullable = false)
    private BigDecimal priceProduct;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;
}
