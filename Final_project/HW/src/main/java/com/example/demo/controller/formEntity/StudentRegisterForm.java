package com.example.demo.controller.formEntity;



import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
public class StudentRegisterForm {

	
	@Getter
	@Setter
	@NotBlank
	private String location;
	
	@Getter
	@Setter
	@NotBlank

	private String phonenumber;
	
	@Getter
	@Setter
	@NotBlank

	private String name;
	
	@Getter
	@Setter
	@NotBlank

	private String password;
	
	@Getter
	@Setter
	@NotBlank

	private String birthday;
	
	@Getter
	@Setter
	@NotBlank

	private String sex;
	

}
