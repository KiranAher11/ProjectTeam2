package com.citiustech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
//@Entity
//@Table(name = "procedures")
public class Procedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long procedureId;
	
	@NotNull
	private String ProcedureType;
	
	@NotNull
	private String procedureText;
	
	public Procedure() {
		
	}

	public Procedure(@NotNull String procedureType, @NotNull String procedureText) {
		super();
		ProcedureType = procedureType;
		this.procedureText = procedureText;
	}

}
