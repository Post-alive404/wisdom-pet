package com.dden.wisdompet.web.rest;

import com.dden.wisdompet.services.ProductService;
import com.dden.wisdompet.web.errors.BadRequestException;
import com.dden.wisdompet.web.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductRestController
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
@RestController
@RequestMapping("api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createOrUpdate(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@RequestParam(name = "id") long id) {
        return this.productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestParam(name = "id") long id, @RequestBody Product product) {
        if (id != product.getProductId()) {
            throw new BadRequestException("incoming id does not match path");
        }
        return this.productService.createOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteProduct(@RequestParam(name = "id") long id) {
        this.productService.deleteProduct(id);
    }
}
