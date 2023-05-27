package com.example.task24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Table(name = "employee")
public class Employee {

    @Column(name = "id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "passport")
    private String passport;
    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "salary")
    private Integer salary;
    @Column(name = "shift")
    private String shift;

    @Column(name = "job_title")
    private String jobTitle;

}
