package com.example.task24.controller;

import com.example.task24.dto.EmployeeDto;
import com.example.task24.dto.ScheduleDto;
import com.example.task24.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employee/new")
    public void saveNewEmployee(@RequestBody EmployeeDto employee) {
        service.saveNew(employee);
    }

    @GetMapping("/employee")
    public List<EmployeeDto> getAllEmployee() {
        return service.getAll();
    }

    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
