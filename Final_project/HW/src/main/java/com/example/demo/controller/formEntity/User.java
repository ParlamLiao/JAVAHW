package com.example.demo.controller.formEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Getter
	@Setter
	@NotNull 
	String phonenumber;
	@Getter
	@Setter	
	@NotBlank
	String password;

};
