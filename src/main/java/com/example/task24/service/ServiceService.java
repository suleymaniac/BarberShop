package com.example.task24.service;

import com.example.task24.dto.ServiceDto;
import com.example.task24.entity.Services;
import com.example.task24.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {


    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public void deleteService(Long id) {
        repository.delete(repository.findServicesById(id));
    }

    public void saveNew(ServiceDto services) {
        repository.save(new Services());
    }

    public List<ServiceDto> getAll() {
        List<Services> services = repository.findAll();
        List<ServiceDto> dtos = new ArrayList<>();
        for (Services m : services) {
            dtos.add(new ServiceDto(m.getName(), m.getPrice()));
        }
        return dtos;
    }

}
