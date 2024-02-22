package com.dden.wisdompet.data.repositories;

import com.dden.wisdompet.data.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * CustomerRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    CustomerEntity findByEmail(String email);
}
