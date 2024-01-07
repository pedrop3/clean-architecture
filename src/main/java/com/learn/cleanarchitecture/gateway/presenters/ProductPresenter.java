package com.learn.cleanarchitecture.gateway.presenters;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.learn.cleanarchitecture.domain.entities.Product;
import com.learn.cleanarchitecture.repository.entities.ProductTable;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductPresenter {

    private final ModelMapper mapper;

    /**
     * Converts an object of the {@code ProductTable} class to an object of the
     * {@code Product} class
     * using the mapping provided by the {@code mapper} object.
     *
     * @param productTable The {@code ProductTable} object to be converted to
     *                     {@code Product}.
     * @return A {@code Product} object resulting from the conversion.
     * 
     * @throws SomeOtherException if another specific exception occurs during the
     *                            mapping process.
     *
     * @see org.modelmapper.ModelMapper - The class providing mapping functionality.
     * @see ProductTable - The source class being mapped.
     * @see Product - The destination class for which the conversion is being
     *      performed.
     */
    public Product presentToDomain(ProductTable productTable) {
        return mapper.map(productTable, Product.class);
    }

    /**
     * Converts a list of objects of the {@code ProductTable} class to a list of
     * objects of the {@code Product} class
     * using the mapping provided by the {@code mapper} object.
     *
     * @param productTable The list of {@code ProductTable} objects to be converted
     *                     to a list of {@code Product} objects.
     * @return A list of {@code Product} objects resulting from the conversion.
     * 
     * @throws SomeOtherException if another specific exception occurs during the
     *                            mapping process.
     *
     * @see org.modelmapper.ModelMapper - The class providing mapping functionality.
     * @see ProductTable - The source class being mapped.
     * @see Product - The destination class for which the conversion is being
     *      performed.
     */
    public List<Product> presentToDomain(List<ProductTable> productTable) {
        return Optional.ofNullable(productTable).orElseGet(Collections::emptyList)
                .stream().map(product -> mapper.map(product, Product.class))
                .collect(Collectors.toList());

    }

    /**
     * Converts an object of the {@link Product} class to an object of the
     * {@link ProductTable} class
     * using the mapping provided by the {@code mapper} object.
     *
     * @param product The {@code Product} object to be converted to
     *                {@code ProductTable}.
     * @return A {@code ProductTable} object resulting from the conversion.
     * 
     * @throws NullPointerException if the {@code product} parameter is
     *                              {@code null}.
     * @throws SomeOtherException   if another specific exception occurs during the
     *                              mapping process.
     *
     * @see org.modelmapper.ModelMapper - The class providing mapping functionality.
     * @see Product - The source class being mapped.
     * @see ProductTable - The destination class for which the conversion is being
     *      performed.
     */
    public ProductTable toProductTable(Product product) {
        return mapper.map(product, ProductTable.class);
    }

}
