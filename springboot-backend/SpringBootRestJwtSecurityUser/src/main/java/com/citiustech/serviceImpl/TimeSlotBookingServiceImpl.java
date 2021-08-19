package com.citiustech.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.model.DateSlot;
import com.citiustech.model.TimeSlot;
import com.citiustech.repo.TimeSlotRepository;
import com.citiustech.service.SlotBookingService;





@Service
public class TimeSlotBookingServiceImpl implements SlotBookingService {

	@Autowired
	TimeSlotRepository timeslotRepository;

	@Override
	public List<TimeSlot> getAvailableSlotsBetween(DateSlot dateslot) {
		return timeslotRepository.findBySlotDateBetween(LocalDate.parse(dateslot.getStartDate()), LocalDate.parse(dateslot.getEndDate()))
				.stream()
				.filter(s->s.getPhysicianId()==dateslot.getPhysicianId()).collect(Collectors.toList());
	}



	@Override
	public List<TimeSlot> getSlotsByDate(DateSlot dateslot) {
		return timeslotRepository.getSlotBySlotDateAndPhysicianId(LocalDate.parse(dateslot.getDate()), dateslot.getPhysicianId());
	}
	
	
}
