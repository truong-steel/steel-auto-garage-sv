package com.vti.steel.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CarCreateForm {

    @NotBlank(message="{car.licensePlate.NotBlank.message}")
    @Length(max = 255, message="{car.licensePlate.Length.message}")
    private String licensePlate;

    @NotNull
    @PastOrPresent
    private LocalDate repairDate;

    @NotBlank(message="Tên khách hàng không được để trống .")
    @Length(max = 255,message="Tên khách hàng không vượt quá 255 kí tự. ")
    private String customerName;

    @NotBlank(message="Catalog không được để trống .")
    @Length(max = 255,message="Catalog không vượt quá 255 kí tự. ")
    private String catalog;

    @NotBlank(message="Tên hãng sản xuất không được để trống .")
    @Length(max = 255,message="Hãng sản xuất không vượt quá 255 kí tự. ")
    private String carMaker;
}
