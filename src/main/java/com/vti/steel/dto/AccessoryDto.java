package com.vti.steel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.steel.controller.AccessoryController;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class AccessoryDto extends RepresentationModel<AccessoryDto> {
    private Long id;

    private String name;

    private Long price;

    private String statusDamaged;

    private String repairStatus;

    @JsonProperty("licensePlate")
    private String carPkLicensePlate;
    @JsonProperty("repairDate")
    private LocalDate carPkRepairDate;

    public AccessoryDto withSelfRel() {

        var controller = methodOn(AccessoryController.class);

        var dto = controller.findById(id);

        var link = linkTo(dto).withSelfRel();

        return add(link);

    }
}
