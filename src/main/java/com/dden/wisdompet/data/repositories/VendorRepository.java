package com.dden.wisdompet.data.repositories;

import com.dden.wisdompet.data.entities.VendorEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * VendorRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
public interface VendorRepository extends CrudRepository<VendorEntity, Long> {
}
