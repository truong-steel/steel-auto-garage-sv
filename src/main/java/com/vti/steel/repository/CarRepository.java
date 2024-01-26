package com.vti.steel.repository;

import com.vti.steel.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<Car, Long> , JpaSpecificationExecutor<Car> {

}
