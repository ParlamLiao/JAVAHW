package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "landlordbill")
public class LandlordBill {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Getter
	@Setter
	@Column(name = "price")
	private int price;
	
	@Getter
	@Setter
	@Column(name = "landlordid")
	@JoinColumn(table = "landlord", name = "landlordid", nullable = false)
	private int landlordid;
	
	@Getter
	@Setter
	@Column(name = "postedtime")
	@NotBlank
	private String postedtime;
	
	@Getter
	@Setter
	@Column(name = "category")
	private String category;
	
}
