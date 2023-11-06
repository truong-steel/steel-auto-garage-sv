package com.vti.steel.service;

import com.vti.steel.dto.CarDto;
import com.vti.steel.entity.Car;
import com.vti.steel.form.CarCreateForm;
import com.vti.steel.form.CarUpdateForm;
import com.vti.steel.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return carRepository.findAll(pageable)
                .map(car -> modelMapper.map(car, CarDto.class));
    }

    @Override
    public CarDto create(CarCreateForm form) {
        var car = modelMapper.map(form, Car.class);
        var pk = modelMapper.map(form ,Car.PrimaryKey.class); //map 2 thuộc tính thuộc primary key
        car.setPk(pk);

        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public CarDto update(CarUpdateForm form) {
        var pk = modelMapper.map(form , Car.PrimaryKey.class);
        var car = carRepository.findById(pk).get();
        modelMapper.map(form,car);
        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    public void deleteById(Car.PrimaryKey pk) {
        carRepository.deleteById(pk);
    }
}
