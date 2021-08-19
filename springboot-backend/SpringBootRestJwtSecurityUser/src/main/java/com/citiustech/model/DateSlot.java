package com.citiustech.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DateSlot {

	private String startDate;
	private String endDate;
	private String date;
	private long physicianId;
	
}
