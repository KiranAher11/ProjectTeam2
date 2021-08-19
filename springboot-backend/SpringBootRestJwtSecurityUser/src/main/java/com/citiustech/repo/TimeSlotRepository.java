package com.citiustech.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.model.TimeSlot;


public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long>{
	
	//public List<Slot> getSlotsByDoctorId(Long physicianId);
	
		public List<TimeSlot> findBySlotDateBetween(LocalDate startDate, LocalDate EndDate);
		
		public List<TimeSlot> getSlotBySlotDateAndPhysicianId(LocalDate sloteDate, long physicianId);

}
