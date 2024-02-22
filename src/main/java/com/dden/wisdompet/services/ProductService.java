package com.dden.wisdompet.services;

import com.dden.wisdompet.data.entities.ProductEntity;
import com.dden.wisdompet.data.entities.VendorEntity;
import com.dden.wisdompet.data.repositories.ProductRepository;
import com.dden.wisdompet.data.repositories.VendorRepository;
import com.dden.wisdompet.web.errors.NotFoundException;
import com.dden.wisdompet.web.models.Product;
import com.dden.wisdompet.web.models.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ProductService
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<ProductEntity> entities = this.productRepository.findAll();
        entities.forEach(entity -> products.add(this.translateDbToWeb(entity)));

        return products;
    }

    public Product getProduct(long id){
        Optional<ProductEntity> optional = this.productRepository.findById(id);
        if (optional.isEmpty()){
            throw new NotFoundException("service not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }
    public Product createOrUpdate(Product product){
        ProductEntity entity = this.translateWebToDb(product);
        entity = this.productRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteProduct(long id){
        this.productRepository.deleteById(id);
    }

    private ProductEntity translateWebToDb(Product product){
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getProductId());
        entity.setName(product.getProductName());
        entity.setPrice(product.getProductPrice());
        entity.setVendorId(product.getVendorId());
        return entity;
    }

    private Product translateDbToWeb(ProductEntity entity){
        return new Product(entity.getId(), entity.getName(), entity.getPrice(),
                entity.getVendorId());
    }
}
