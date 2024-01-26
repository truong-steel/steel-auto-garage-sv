package com.vti.steel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name="car_id",nullable = false)

    private Car car;

}
