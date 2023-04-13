package com.isep.productc.services;

import java.util.Optional;

import com.isep.productc.model.Product;
import com.isep.productc.model.ProductDTO;

public interface ProductService {

    Optional<ProductDTO> findBySku(final String sku);

    ProductDTO create(final Product manager);

    ProductDTO updateBySku(final String sku, final Product product);

    void deleteBySku(final String sku);
}
