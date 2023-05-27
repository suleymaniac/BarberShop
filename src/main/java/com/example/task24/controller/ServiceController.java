package com.example.task24.controller;

import com.example.task24.dto.ServiceDto;
import com.example.task24.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }


    @PostMapping("/service/new")
    public void saveNewService(@RequestBody ServiceDto services) {
        service.saveNew(services);
    }

    @GetMapping("/services")
    public List<ServiceDto> getAllServices() {
        return service.getAll();
    }

    @DeleteMapping("/service/delete/{id}")
    public void deleteService(@PathVariable Long id) {
        service.deleteService(id);
    }

}
