package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hs_stu")
public class Hs_Stu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Hs_Stu_id")
	public int id;

	@Getter
	@Setter
	@NotNull
	@Column(name = "houseid")
	@JoinColumn(name = "houseid") // 用法存疑
	public int houseid;
	
	@Getter
	@Setter
	@NotNull
	@Column(name = "ownerid")
	@JoinColumn(name = "houseid") // 用法存疑
	public int ownerid;

	@Getter
	@Setter
	@NotNull
	@Column(name = "tenantid")
	@JoinColumn(name = "studentid") // 用法存疑
	public int tenantid;

	@Getter
	@Setter
	@NotBlank
	@Column(name = "meetingplace")
	public String meetingPlace;
	@Getter
	@Setter
	@NotBlank
	@Column(name = "meetingtime")
	public String meetingTime;
}
