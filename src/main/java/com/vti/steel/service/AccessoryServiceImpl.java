package com.vti.steel.service;

import com.vti.steel.dto.AccessoryDto;
import com.vti.steel.entity.Accessory;
import com.vti.steel.entity.Car;
import com.vti.steel.form.AccessoryCreateForm;
import com.vti.steel.form.AccessoryUpdateForm;
import com.vti.steel.repository.AccessoryRepository;
import com.vti.steel.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AccessoryServiceImpl implements AccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    @Override
    public AccessoryDto create(Long id ,AccessoryCreateForm form) {
        var accessory = modelMapper.map(form , Accessory.class);
        var car = carRepository.findById(id).get();
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);

        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable)
                .map(accessory -> modelMapper.map(accessory, AccessoryDto.class));
    }

    @Override
    public AccessoryDto update(Long id ,AccessoryUpdateForm form) {
        var accessory = accessoryRepository.findById(id).get();
        modelMapper.map(form , accessory);
        var savedAccessory = accessoryRepository.save(accessory);

        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    public AccessoryDto findById(Long id) {
        return accessoryRepository.findById(id)
                .map(comment -> modelMapper.map(comment, AccessoryDto.class))
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
