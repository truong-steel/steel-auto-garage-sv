package com.vti.steel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SteelAutoGarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteelAutoGarageApplication.class, args);
	}
	@Bean // Cho modelmapper tham gia vào SpringAOC Container
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
