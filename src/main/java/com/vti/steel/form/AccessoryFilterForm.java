package com.vti.steel.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryFilterForm {
    private String search;
    private LocalDate minCreatedDate;
    private LocalDate maxCreatedDate;
    private Long carId;
}
