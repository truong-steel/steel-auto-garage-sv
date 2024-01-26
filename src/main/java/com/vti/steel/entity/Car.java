package com.vti.steel.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="license_plate", unique = true)
    private String licensePlate;

    @Column(name="repair_date", nullable = false)
    private LocalDate repairDate;

    @Column(name="customer_name", nullable = false)
    private String customerName;

    @Column(name="catalog", nullable = false)
    private String catalog;

    @Column(name="car_maker", nullable = false)
    private String carMaker;

    @OneToMany(mappedBy = "car")
    private List<Accessory> accessories;

}
