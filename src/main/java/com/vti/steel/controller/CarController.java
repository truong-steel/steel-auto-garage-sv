package com.vti.steel.controller;

import com.vti.steel.dto.CarDto;
import com.vti.steel.entity.Car;
import com.vti.steel.form.CarCreateForm;
import com.vti.steel.form.CarUpdateForm;
import com.vti.steel.service.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@CrossOrigin("http://127.0.0.1:5500/")
public class CarController {
    private final CarService carService;
@PostMapping("/api/v1/cars")
@ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@RequestBody @Valid CarCreateForm form){
        return carService.create(form);
    }

@GetMapping("/api/v1/cars")
    public Page<CarDto> findAll(Pageable pageable){
    return carService.findAll(pageable);
}

@PutMapping("/api/v1/cars")
    public CarDto update(@RequestBody @Valid CarUpdateForm form){
    return carService.update(form);
}

@DeleteMapping("/api/v1/cars")
    public void deleteById(@RequestBody Car.PrimaryKey pk){
    carService.deleteById(pk);
}
}
