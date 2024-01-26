package com.vti.steel.service;

import com.vti.steel.dto.AccessoryDto;
import com.vti.steel.form.AccessoryCreateForm;
import com.vti.steel.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    AccessoryDto create(Long carId ,AccessoryCreateForm form);
    Page<AccessoryDto> findAll(Pageable pageable);
    AccessoryDto update(Long id , AccessoryUpdateForm form);

    AccessoryDto findById(Long id);
    void deleteById(Long id);
}
