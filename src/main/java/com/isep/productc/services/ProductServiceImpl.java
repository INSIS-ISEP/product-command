package com.isep.productc.services;

import com.isep.productc.model.Product;
import com.isep.productc.model.ProductDTO;
import com.isep.productc.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<ProductDTO> findBySku(String sku) {
        final Optional<Product> product = repository.findBySku(sku);

        if( product.isEmpty() )
            return Optional.empty();
        else
            return Optional.of( product.get().toDto() );
    }

    @Override
    public ProductDTO create(final Product product) {
        final Product p = new Product(product.getSku(), product.getDesignation(), product.getDescription());

        return repository.save(p).toDto();
    }

    @Override
    public ProductDTO updateBySku(String sku, Product product) {
        
        final Optional<Product> productToUpdate = repository.findBySku(sku);

        if( productToUpdate.isEmpty() ) return null;

        productToUpdate.get().updateProduct(product);

        Product productUpdated = repository.save(productToUpdate.get());
        
        return productUpdated.toDto();
    }

    @Override
    public void deleteBySku(String sku) {
        repository.deleteBySku(sku);
    }
}
