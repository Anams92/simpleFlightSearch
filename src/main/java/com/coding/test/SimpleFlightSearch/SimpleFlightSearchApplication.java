package com.coding.test.SimpleFlightSearch;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableJpaRepositories(basePackages = {"mypkg"})

@EntityScan(basePackages = { "com.coding.test.SimpleFlightSearch" })
public class SimpleFlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFlightSearchApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
