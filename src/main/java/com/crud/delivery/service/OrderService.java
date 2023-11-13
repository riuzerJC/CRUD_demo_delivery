package com.crud.delivery.service;

import com.crud.delivery.entity.Order;
import com.crud.delivery.entity.OrderProduct;
import com.crud.delivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private OrderProductService orderProductService;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> getOrder(Long id){
        return orderRepository.findById(id);
    }

    public void saveOrUpdate(Order order){

        List<OrderProduct> orderProducts = order.getOrderProducts();
        BigDecimal totalPrice = orderProductService.calculateTotalPrice(orderProducts);
        order.setPriceTotal(totalPrice);
        orderRepository.save(order);
    }

    public void delete(Long id){
        orderRepository.deleteById(id);
    }

}
