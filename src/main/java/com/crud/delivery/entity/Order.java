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

    @Column(name="dni", nullable = false)
    private String dni;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="number_phone", nullable = false)
    private String numberPhone;
    @Column(name="address", nullable = false)
    private String address;

    @Column(name="method_payment", nullable = false)
    private String methodPayment;

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
}
