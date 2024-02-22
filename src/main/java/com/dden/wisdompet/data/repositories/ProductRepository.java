package com.dden.wisdompet.data.repositories;

import com.dden.wisdompet.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * ProductRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
