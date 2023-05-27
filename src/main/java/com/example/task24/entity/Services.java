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

@Table(name = "service")
public class Services {

    @Column(name = "id")
    private Long id;

    @Column(name = "code_service")
    private String codeService;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

}
