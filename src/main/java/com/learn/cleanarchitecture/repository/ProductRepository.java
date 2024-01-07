package com.learn.cleanarchitecture.repository;

import org.springframework.stereotype.Repository;

import com.learn.cleanarchitecture.repository.entities.ProductTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<ProductTable, Integer> {


    @Query(value = "SELECT EXISTS(SELECT 1 FROM product WHERE code = :productCode and " +
            "TRIM(LOWER(\"name\")) = TRIM(LOWER(:name)))", nativeQuery = true)
    boolean existsProduct(int productCode, String name);

    void deleteByCode(int code);

    ProductTable findByCode(int code);
}
