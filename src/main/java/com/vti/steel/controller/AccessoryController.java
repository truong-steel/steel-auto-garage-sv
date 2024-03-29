package com.vti.steel.controller;

import com.vti.steel.dto.AccessoryDto;
import com.vti.steel.form.AccessoryCreateForm;
import com.vti.steel.form.AccessoryUpdateForm;
import com.vti.steel.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class AccessoryController {
    private final AccessoryService accessoryService;
    @PostMapping("/api/v1/{carId}/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@PathVariable("carId") Long carId , @RequestBody @Valid AccessoryCreateForm form){
        return accessoryService.create(carId,form);
    }
    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessoryService.findAll(pageable);
    }
    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(@PathVariable("id") Long id ,@RequestBody @Valid AccessoryUpdateForm form){
        return accessoryService.update(id,form);
    }
    @GetMapping("/api/v1/accessories/{id}")
    public AccessoryDto findById(@PathVariable("id") Long id){
        return accessoryService.findById(id);
    }
    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        accessoryService.deleteById(id);
    }
}
