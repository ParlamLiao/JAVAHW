package com.example.demo.controller.formEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class HouseRegisterForm {
	
	@Getter
	@Setter
	@NotBlank

	private String location;
	
	@Getter
	@Setter
	@NotBlank

	private String roomtype;
	
	@Getter
	@Setter
	@NotNull

	private int size;
	
	@Getter
	@Setter
	@NotNull

	private int rent;
}
