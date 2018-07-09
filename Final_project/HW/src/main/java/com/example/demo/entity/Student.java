package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	@NotNull 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentid")
	public int id;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="location")
	private String location;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="name")
	private String name;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="password")
	private String password;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="birthday")
	private String birthday;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="sex")
	private String sex;
	

	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "location","phonenumber","name","password","birthday","sex");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "location","phonenumber","name","password","birthday","sex");
	}
}
