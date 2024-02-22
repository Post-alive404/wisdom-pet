package com.dden.wisdompet.services;

import com.dden.wisdompet.data.entities.ServiceEntity;
import com.dden.wisdompet.data.repositories.ServiceRepository;
import com.dden.wisdompet.web.errors.NotFoundException;
import com.dden.wisdompet.web.models.ServiceModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ServiceService
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceModel> getAllServices() {
        List<ServiceModel> serviceModels = new ArrayList<>();
        Iterable<ServiceEntity> entities = this.serviceRepository.findAll();
        entities.forEach(entity -> serviceModels.add(this.translateDbToWeb(entity)));

        return serviceModels;
    }

    public ServiceModel getService(long id){
        Optional<ServiceEntity> optional = this.serviceRepository.findById(id);
        if (optional.isEmpty()){
            throw new NotFoundException("service not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }
    public ServiceModel createOrUpdate(ServiceModel serviceModel){
        ServiceEntity entity = this.translateWebToDb(serviceModel);
        entity = this.serviceRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteService(long id){
        this.serviceRepository.deleteById(id);
    }

    private ServiceEntity translateWebToDb(ServiceModel serviceModel){
        ServiceEntity entity = new ServiceEntity();
        entity.setId(serviceModel.getServiceId());
        entity.setName(serviceModel.getServiceName());
        entity.setPrice(serviceModel.getServicePrice());
        return entity;
    }

    private ServiceModel translateDbToWeb(ServiceEntity entity){
        return new ServiceModel(entity.getId(), entity.getName(), entity.getPrice());
    }
}
