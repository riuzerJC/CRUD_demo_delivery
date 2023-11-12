package com.crud.delivery.service;

import com.crud.delivery.entity.Product;
import com.crud.delivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProducts(Long id){
        return productRepository.findById(id);
    }

    public void saveOrUpdate(Product product){
        productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }


}
