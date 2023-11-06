package com.vti.steel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="accessory")
public class Accessory {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="price",nullable = false)
    private Long price;

    @Column(name="status_damaged",nullable = false)
    private String statusDamaged;

    @Column(name="repair_status",nullable = false)
    private String repairStatus;

    @ManyToOne
    @JoinColumns(value= {
            @JoinColumn(name= "license_plate",referencedColumnName = "license_plate"),
            @JoinColumn(name="repair_date",referencedColumnName = "repair_date")
    })
    private Car car;

}
