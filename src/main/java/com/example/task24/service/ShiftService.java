package com.example.task24.service;

import com.example.task24.dto.ShiftDto;
import com.example.task24.entity.Shift;
import com.example.task24.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepository repository;

    public ShiftService(ShiftRepository repository) {
        this.repository = repository;
    }

    public void deleteShift(Long id) {
        repository.delete(repository.findShiftById(id));
    }

    public List<ShiftDto> getAll() {
        List<Shift> shift = repository.findAll();
        List<ShiftDto> dtos = new ArrayList<>();
        for (Shift m : shift) {
            dtos.add(new ShiftDto(m.getCode(), m.getName()));
        }
        return dtos;
    }

    public void saveNew(ShiftDto shift) {
        repository.save(new Shift());
    }

}
