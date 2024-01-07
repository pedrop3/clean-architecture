package com.learn.cleanarchitecture.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int code;
    private String name;
    private String description;
    private double price;
    private int quantity;

    
}
