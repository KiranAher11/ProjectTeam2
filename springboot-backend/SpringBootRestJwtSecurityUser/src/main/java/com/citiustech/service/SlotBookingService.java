package com.citiustech.service;

import java.util.List;

import com.citiustech.model.DateSlot;
import com.citiustech.model.TimeSlot;



public interface SlotBookingService {

	//Slot bookSlot(Long physicianId, Slot slot);
	
		 List<TimeSlot> getAvailableSlotsBetween(DateSlot slotDate);
		 
		 List<TimeSlot> getSlotsByDate(DateSlot slotDate);
		 
	
}
