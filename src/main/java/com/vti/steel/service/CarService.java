package com.vti.steel.service;

import com.vti.steel.dto.CarDto;
import com.vti.steel.entity.Car;
import com.vti.steel.form.CarCreateForm;
import com.vti.steel.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDto> findAll(Pageable pageable);
    CarDto create(CarCreateForm form);
    CarDto update(CarUpdateForm form);
    void deleteById(Car.PrimaryKey pk);
}
