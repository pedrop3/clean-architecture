package com.learn.cleanarchitecture.usercase.produt;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.cleanarchitecture.domain.entities.Product;
import com.learn.cleanarchitecture.gateway.ProductGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListProduct {

    private final ProductGateway productGateway;

    public List<Product> execute() {
        return productGateway.findAll();
    }
}