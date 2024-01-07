package com.learn.cleanarchitecture.gateway;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.cleanarchitecture.domain.entities.Product;
import com.learn.cleanarchitecture.gateway.presenters.ProductPresenter;
import com.learn.cleanarchitecture.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductGateway {

    private final ProductRepository productRepository;
    private final ProductPresenter productPresenter;

    public void save(Product product) {
        productRepository.save(productPresenter.toProductTable(product));
    }

    public boolean checkIfProductAlreadyExists(int code, String name) {
        return productRepository.existsProduct(code, name);
    }

    public void deleteProductByCode(int code) {
        productRepository.deleteByCode(code);
    }

    public Product findProduct(int code) {
        return productPresenter.presentToDomain(productRepository.findByCode(code));
    }

    public List<Product> findAll() {
        return productPresenter.presentToDomain(productRepository.findAll());
    }

}
