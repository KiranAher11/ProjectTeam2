package com.citiustech.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.DateSlot;
import com.citiustech.model.TimeSlot;
import com.citiustech.service.SlotBookingService;



@RestController
@RequestMapping("/api")
public class TimeSlotController {
	
	@Autowired
	private SlotBookingService slotBookingService;

	@GetMapping("/slot/date/physicianId")
	 public ResponseEntity<List<TimeSlot>> getSlotsByDate(@RequestBody DateSlot dateslot) {
		return new ResponseEntity<List<TimeSlot>>(slotBookingService.getSlotsByDate(dateslot), HttpStatus.OK);
		 
	 }
	
	@GetMapping("/slot/dateBetween")
	public ResponseEntity<List<TimeSlot>> getSlotsBetween(@RequestBody DateSlot dateslot) {
		return new ResponseEntity<List<TimeSlot>>(slotBookingService.getAvailableSlotsBetween(dateslot), HttpStatus.OK);
	}

}
