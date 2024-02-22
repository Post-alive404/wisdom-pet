package com.dden.wisdompet.web.rest;

import com.dden.wisdompet.services.VendorService;
import com.dden.wisdompet.web.errors.BadRequestException;
import com.dden.wisdompet.web.models.Vendor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * VendorRestController
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@RestController
@RequestMapping("api/vendors")
public class VendorRestController {

    private final VendorService vendorService;

    public VendorRestController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getAllVendors(){
        return this.vendorService.getAllVendors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@RequestBody Vendor vendor){
        return this.vendorService.createOrUpdate(vendor);
    }

    @GetMapping("/{id}")
    public Vendor getVendor(@RequestParam(name = "id")long id){
        return this.vendorService.getVendor(id);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@RequestParam(name = "id")long id, @RequestBody Vendor vendor){
        if (id != vendor.getVendorId()){
            throw new BadRequestException("incoming id does not match path");
        }
        return this.vendorService.createOrUpdate(vendor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteVendor(@RequestParam(name = "id") long id) {
        this.vendorService.deleteVendor(id);
    }
}
