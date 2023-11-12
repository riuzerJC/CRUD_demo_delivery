package com.crud.delivery.controller;

import com.crud.delivery.entity.Order;
import com.crud.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getOrder();
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getById(@PathVariable("orderId") Long orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Order order){
        orderService.saveOrUpdate(order);
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable("orderId") Long orderId){
        orderService.delete(orderId);
    }
}
