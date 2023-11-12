package com.crud.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name="total_price", nullable = false)
    private BigDecimal priceTotal;

    @Column(name = "order_date_time")
    private LocalDateTime orderDateTime;

    @PrePersist
    public void prePersist() {
        orderDateTime = LocalDateTime.now();
    }



    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    @ManyToOne
    Client client;

}
