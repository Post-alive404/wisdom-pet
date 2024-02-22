package com.dden.wisdompet.web.rest;

import com.dden.wisdompet.services.ServiceService;
import com.dden.wisdompet.web.errors.BadRequestException;
import com.dden.wisdompet.web.models.ServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ServiceRestController
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/services")
public class ServiceRestController {
    private final ServiceService service;

    public ServiceRestController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceModel> getAllServices(){
        return this.service.getAllServices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceModel createService(@RequestBody ServiceModel serviceModel){
        return this.service.createOrUpdate(serviceModel);
    }

    @GetMapping("/{id}")
    public ServiceModel getService(@RequestParam(name = "id")long id){
        return this.service.getService(id);
    }

    @PutMapping("/{id}")
    public ServiceModel updateService(@RequestParam(name = "id")long id, @RequestBody ServiceModel serviceModel){
        if(id != serviceModel.getServiceId()){
            throw new BadRequestException("incoming id does not match path");
        }
        return this.service.createOrUpdate(serviceModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteService(@RequestParam(name = "id")long id){
        this.service.deleteService(id);
    }

}
