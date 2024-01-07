package com.learn.cleanarchitecture.usercase.produt;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.learn.cleanarchitecture.domain.entities.Product;
import com.learn.cleanarchitecture.gateway.ProductGateway;

@Service
@AllArgsConstructor
public class FindProduct {

    private final ProductGateway productGateway;

    public Product execute(int code) throws Exception {
        Product product = productGateway.findProduct(code);
        if (product == null) {
            throw new Exception("This code is necessery"); //TO-DO Custum Exception
        }

        return product;
    }

}