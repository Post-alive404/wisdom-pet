package com.dden.wisdompet.services;

import com.dden.wisdompet.data.entities.VendorEntity;
import com.dden.wisdompet.data.repositories.VendorRepository;
import com.dden.wisdompet.web.errors.NotFoundException;
import com.dden.wisdompet.web.models.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * VendorService
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new ArrayList<>();
        Iterable<VendorEntity> entities = this.vendorRepository.findAll();
        entities.forEach(entity -> vendors.add(this.translateDbToWeb(entity)));

        return vendors;
    }

    public Vendor getVendor(long id){
        Optional<VendorEntity> optional = this.vendorRepository.findById(id);
        if (optional.isEmpty()){
            throw new NotFoundException("service not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }
    public Vendor createOrUpdate(Vendor vendor){
        VendorEntity entity = this.translateWebToDb(vendor);
        entity = this.vendorRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteVendor(long id){
        this.vendorRepository.deleteById(id);
    }

    private VendorEntity translateWebToDb(Vendor vendor){
        VendorEntity entity = new VendorEntity();
        entity.setId(vendor.getVendorId());
        entity.setName(vendor.getVendorName());
        entity.setContact(vendor.getVendorContact());
        entity.setPhone(vendor.getVendorPhone());
        entity.setEmail(vendor.getVendorEmail());
        entity.setAddress(vendor.getVendorAddress());
        return entity;
    }

    private Vendor translateDbToWeb(VendorEntity entity){
        return new Vendor(entity.getId(), entity.getName(), entity.getContact(),
                entity.getPhone(), entity.getEmail(), entity.getAddress());
    }
}
