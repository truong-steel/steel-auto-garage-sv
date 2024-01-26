package com.vti.steel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.steel.controller.CarController;
import com.vti.steel.entity.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter

public class CarDto extends RepresentationModel<CarDto> {
    //mapping các thuộc tính từ Car.Entity qua Car.Dto
    private Long id;
    private String licensePlate;
    private LocalDate repairDate;
    private String customerName;
    private String catalog;
    private String carMaker;
    private List<AccessoryDto> accessories;
}

