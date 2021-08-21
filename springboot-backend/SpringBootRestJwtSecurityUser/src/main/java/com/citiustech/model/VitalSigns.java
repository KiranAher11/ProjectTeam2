package com.citiustech.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;

@Data
//@Entity
//@Table(name = "vitalSigns")
public class VitalSigns {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long VitalId;
	
	@NotNull
	private String height;
	
	@NotNull
	private String weight;

	private String bloodPressure;

	@NotNull
	private String bodyTemp;
	
	@NotNull
	private String respiratinRate;
	
	public VitalSigns() {
		
	}

	public VitalSigns(@NotNull String height, @NotNull String weight, String bloodPressure, @NotNull String bodyTemp,
			@NotNull String respiratinRate) {
		super();
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.bodyTemp = bodyTemp;
		this.respiratinRate = respiratinRate;
	}

}
