package com.example.task24.controller;

import com.example.task24.dto.ScheduleDto;
import com.example.task24.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping("/schedule/new")
    public void addNewSchedule(@RequestBody ScheduleDto schedule) {
        System.out.println(schedule);
        service.saveNew(schedule);
    }

    @GetMapping("/schedules")
    public List<ScheduleDto> getAllSchedules() {
        return service.getAll();
    }

    @DeleteMapping("/schedule/delete/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        service.deleteSchedule(id);
    }
}
