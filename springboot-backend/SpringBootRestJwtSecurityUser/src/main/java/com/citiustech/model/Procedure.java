package com.citiustech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="procedure_master")
public class Procedure{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String procedureType;
	
	@NotNull
	private String procedureText;
	
	public Procedure() {
		
	}

	public Procedure(@NotNull String procedureType, @NotNull String procedureText) {
		super();
		this.procedureType = procedureType;
		this.procedureText = procedureText;
	}

}
