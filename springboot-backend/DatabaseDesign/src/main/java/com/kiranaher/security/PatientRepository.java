package com.kiranaher.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiranaher.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
