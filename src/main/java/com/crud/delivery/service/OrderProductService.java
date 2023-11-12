package com.crud.delivery.service;

import com.crud.delivery.entity.Order;
import com.crud.delivery.entity.OrderProduct;
import com.crud.delivery.repository.OrderProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    public BigDecimal calculateTotalPrice(List<OrderProduct> orderProducts) {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (OrderProduct orderProduct : orderProducts) {
            BigDecimal productPrice = orderProduct.getProduct().getPriceProduct();
            int quantity = orderProduct.getQuantity();

            BigDecimal productTotalPrice = productPrice.multiply(BigDecimal.valueOf(quantity));
            totalPrice = totalPrice.add(productTotalPrice);
        }

        return totalPrice;
    }


}
