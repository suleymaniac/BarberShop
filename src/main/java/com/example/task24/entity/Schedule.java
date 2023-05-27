package com.example.task24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Table(name = "schedule")
public class Schedule {
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "service")
    private String service;

    @Column(name = "full_name_client")
    private String fullNameClient;

    @Column(name = "phone_client")
    private String phoneClient;

    @Column(name = "employee_id")
    private Long employeeId;
}
