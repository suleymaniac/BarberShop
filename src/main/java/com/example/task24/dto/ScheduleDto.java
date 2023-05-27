package com.example.task24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ScheduleDto {

    private String date;

    private String time;

    private String service;


    private String fullNameClient;

    private String phoneClient;

    private Long employeeId;

}
