package com.example.task24.controller;

import com.example.task24.dto.ServiceDto;
import com.example.task24.dto.ShiftDto;
import com.example.task24.service.ServiceService;
import com.example.task24.service.ShiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShiftController {

    private final ShiftService shift;

    public ShiftController(ShiftService shift) {
        this.shift = shift;
    }


    @PostMapping("/shift/new")
    public void saveNewShift(@RequestBody ShiftDto shifts) {
        shift.saveNew(shifts);
    }

    @GetMapping("/shift")
    public List<ShiftDto> getAllShift() {
        return shift.getAll();
    }


    @DeleteMapping("/shift/delete/{id}")
    public void deleteShift(@PathVariable Long id) {
        shift.deleteShift(id);
    }

}
