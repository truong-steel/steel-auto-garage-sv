package com.vti.steel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class CarDto {
    //mapping các thuộc tính từ Car.Entity qua Car.Dto
    @JsonProperty("licensePlate") // trả về tên biến hiển thị trên postman
    private String pkLicensePlate;
    @JsonProperty("repairDate")
    private LocalDate pkRepairDate;
    private String customerName;
    private String catalog;
    private String carMaker;
}
