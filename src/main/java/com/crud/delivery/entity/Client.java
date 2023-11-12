package com.crud.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

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


    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}
