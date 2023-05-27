package com.example.task24.service;

import com.example.task24.dto.EmployeeDto;
import com.example.task24.dto.ScheduleDto;
import com.example.task24.entity.Employee;
import com.example.task24.entity.Schedule;
import com.example.task24.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.delete(employeeRepository.findEmployeeById(id));
    }

    public List<EmployeeDto> getAll() {
        List<Employee> all = employeeRepository.findAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        for (Employee employee:all) {
            dtos.add(new EmployeeDto(employee.getFullName(), employee.getPhone(),
                    employee.getShift()));
        }
        return dtos;
    }

    public void saveNew(EmployeeDto employee) {
        employeeRepository.save(new Employee());
    }
}
