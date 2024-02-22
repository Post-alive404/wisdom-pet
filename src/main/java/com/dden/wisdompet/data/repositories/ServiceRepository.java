package com.dden.wisdompet.data.repositories;

import com.dden.wisdompet.data.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * ServiceRepository
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {
}
