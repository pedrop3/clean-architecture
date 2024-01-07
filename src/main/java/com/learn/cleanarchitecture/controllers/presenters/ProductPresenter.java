package com.learn.cleanarchitecture.controllers.presenters;

import java.util.List;
import java.util.stream.Collectors;

import com.learn.cleanarchitecture.controllers.dto.ProductDto;
import com.learn.cleanarchitecture.domain.entities.Product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ProductPresenter
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductPresenter {
    public static Product toDomain(ProductDto productDto) {
        return Product.builder()
                .code(productDto.getCode())
                .description(productDto.getDescription())
                .name(productDto.getName())
                .quantity(productDto.getQuantity())
                .price(productDto.getPrice())
                .build();
    }

    public static List<ProductDto> toDtos(List<Product> products) {
        return products.stream().map(product -> ProductDto.builder()
                .code(product.getCode())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity()).build()).collect(Collectors.toList());
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .code(product.getCode())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity()).build();
    }
}
