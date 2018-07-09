package com.example.demo.entity;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="house")
public class House implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@NotNull 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="houseid")
	public int id;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="location")
	private String location;
	
	@Getter
	@Setter
	@NotBlank
	@Column(name="roomtype")
	private String roomtype;
	
	@Getter
	@Setter
	@NotNull
	@Column(name="size")
	private int size;
	@Getter
	@Setter
	@NotNull
	@Column(name="ownerid") 
	@JoinColumn(name="landlordid")
	private int ownerid;
	
	@Getter
	@Setter
	@NotNull
	@Column(name="rent")
	private int rent;
	
	@Getter
	@Setter
	@NotNull
	@Column(name="sold")
	private int sold;
	

	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "location","roomtype");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this,"location","roomtype");
	}
}
