package com.crud.delivery.controller;

import com.crud.delivery.entity.Product;
import com.crud.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getById(@PathVariable("productId") Long productId){
        return productService.getProducts(productId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Product product){
        productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") Long productId){
        productService.delete(productId);
    }
}