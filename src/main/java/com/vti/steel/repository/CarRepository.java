package com.vti.steel.repository;

import com.vti.steel.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Car.PrimaryKey> {

}
