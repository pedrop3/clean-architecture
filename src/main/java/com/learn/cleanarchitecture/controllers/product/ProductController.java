package com.learn.cleanarchitecture.controllers.product;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.cleanarchitecture.controllers.dto.ProductDto;
import com.learn.cleanarchitecture.controllers.presenters.ProductPresenter;
import com.learn.cleanarchitecture.domain.entities.Product;
import com.learn.cleanarchitecture.usercase.produt.CreateProduct;
import com.learn.cleanarchitecture.usercase.produt.FindProduct;
import com.learn.cleanarchitecture.usercase.produt.ListProduct;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final CreateProduct createProduct;
    private final FindProduct findProduct;
    private final ListProduct listProduct;

    @PostMapping()
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) throws Exception {

        createProduct.execute(ProductPresenter.toDomain(productDto));

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand().toUri())
                .build();

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> listAllProducts() {
        return ProductPresenter.toDtos(listProduct.execute());
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto findProduct(@PathVariable(value = "code") int code) {
        try {
            return ProductPresenter.toDto(findProduct.execute(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductDto();
    }

}