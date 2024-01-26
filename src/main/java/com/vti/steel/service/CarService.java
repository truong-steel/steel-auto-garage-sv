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
    CarDto findById(Long id);
    CarDto create(CarCreateForm form);
    CarDto update(Long id,CarUpdateForm form);
    void deleteById(Long id);
}
