package com.citiustech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.model.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {

}
