package com.learn.cleanarchitecture.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private int id;
    private int code;
    private String name;
    private String description;
    private double price;
    private int quantity;

}
