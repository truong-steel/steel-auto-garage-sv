package com.vti.steel.service;

import com.vti.steel.dto.CarDto;
import com.vti.steel.entity.Car;
import com.vti.steel.form.CarCreateForm;
import com.vti.steel.form.CarFilterForm;
import com.vti.steel.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDto> findAll(CarFilterForm form , Pageable pageable);
    CarDto create(CarCreateForm form);
    CarDto update(CarUpdateForm form);
    CarDto findById(Car.PrimaryKey pk);
    void deleteById(Car.PrimaryKey pk);
}
