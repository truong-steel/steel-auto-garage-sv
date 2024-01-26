package com.vti.steel.service;

import com.vti.steel.dto.CarDto;
import com.vti.steel.entity.Car;
import com.vti.steel.form.CarCreateForm;
import com.vti.steel.form.CarFilterForm;
import com.vti.steel.form.CarUpdateForm;
import com.vti.steel.repository.CarRepository;
import com.vti.steel.specification.CarSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<CarDto> findAll(CarFilterForm form , Pageable pageable) {
        var spec = CarSpecification.buildSpec(form);
        return carRepository.findAll(spec ,pageable)
                .map(car -> modelMapper.map(car, CarDto.class));
    }

    @Override
    public CarDto findById(Long id) {
        return carRepository.findById(id).map(car -> modelMapper.map(car , CarDto.class)).orElse(null);
    }

    @Override
    public CarDto create(CarCreateForm form) {
        var car = modelMapper.map(form, Car.class);
        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public CarDto update(Long id ,CarUpdateForm form) {

        var car = carRepository.findById(id).get();
        modelMapper.map(form , car);

        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
