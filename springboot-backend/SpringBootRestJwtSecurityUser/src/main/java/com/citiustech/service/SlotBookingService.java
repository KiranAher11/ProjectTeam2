package com.citiustech.service;

import java.util.List;

import com.citiustech.model.DateSlot;
import com.citiustech.model.TimeSlot;



public interface SlotBookingService {

	
	
		 List<TimeSlot> getAvailableSlotsBetween(DateSlot slotDate);
		//TimeSlot bookSlot(Long physicianId, TimeSlot timeslot);
		 List<TimeSlot> getSlotsByDate(DateSlot slotDate);
		 
	
}
