package com.learn.cleanarchitecture.usercase.produt;

import org.springframework.stereotype.Service;

import com.learn.cleanarchitecture.domain.entities.Product;
import com.learn.cleanarchitecture.gateway.ProductGateway;

import lombok.AllArgsConstructor;

/**
 * CreateProduct
 */

@Service
@AllArgsConstructor
public class CreateProduct {

    private final ProductGateway productGateway;

    public void execute(Product product) throws Exception {

        if (productGateway.checkIfProductAlreadyExists(product.getCode(), product.getName())) {
            throw new Exception("This code was association to another product"); //TO-DO Custum Exception
        }

        productGateway.save(product);
    }
}
