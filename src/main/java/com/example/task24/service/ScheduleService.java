package com.example.task24.service;

import com.example.task24.dto.EmployeeDto;
import com.example.task24.dto.ScheduleDto;
import com.example.task24.entity.Employee;
import com.example.task24.entity.Schedule;
import com.example.task24.repository.EmployeeRepository;
import com.example.task24.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository schedRepository;

    public ScheduleService(ScheduleRepository schedRepository) {

        this.schedRepository = schedRepository;
    }
    public void saveNew(ScheduleDto dto) {

        Schedule schedule = new Schedule(getAll() == null ? 1L : getAll().size() + 1, dto.getDate(), dto.getTime(),
                dto.getService(), dto.getFullNameClient(), dto.getPhoneClient(), dto.getEmployeeId());
        schedRepository.save(schedule);
    }

    public List<ScheduleDto> getAll() {
        List<Schedule> all = schedRepository.findAll();
        List<ScheduleDto> dtos = new ArrayList<>();
        for (Schedule schedule:all) {
           dtos.add(new ScheduleDto(schedule.getDate(), schedule.getTime(),
                    schedule.getService(), schedule.getFullNameClient(), schedule.getPhoneClient(), schedule.getEmployeeId()));
        }
        return dtos;
    }

    public void deleteSchedule(Long id) {
        schedRepository.delete(schedRepository.findScheduleById(id));
    }
}
