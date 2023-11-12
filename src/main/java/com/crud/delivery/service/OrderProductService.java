package com.crud.delivery.service;

import com.crud.delivery.entity.Order;
import com.crud.delivery.entity.OrderProduct;
import com.crud.delivery.entity.Product;
import com.crud.delivery.repository.OrderProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductService productService;

    public BigDecimal calculateTotalPrice(List<OrderProduct> orderProducts) {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (OrderProduct orderProduct : orderProducts) {
            Long productId = orderProduct.getProduct().getProductId();
            int quantity = orderProduct.getQuantity();

            Optional<Product> productOptional = productService.getProducts(productId);

            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                BigDecimal productPrice = product.getPriceProduct();

                BigDecimal productTotalPrice = productPrice.multiply(BigDecimal.valueOf(quantity));
                totalPrice = totalPrice.add(productTotalPrice);
            } else {
                System.out.println("Producto no encontrado para el ID: " + productId);
            }
        }

        return totalPrice;
    }


}
