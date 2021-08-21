package com.citiustech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.citiustech.model.Diagnosis;
import com.citiustech.model.Medication;
import com.citiustech.model.Patient;
import com.citiustech.model.PatientDetails;
import com.citiustech.model.PatientVisitData;
import com.citiustech.model.Procedure;
import com.citiustech.model.VitalSigns;
import com.citiustech.repo.PatientDetailsRepository;
import com.citiustech.repo.PatientRepository;
import com.citiustech.response.MessageResponse;

public class PatientVisitService {

	@Autowired
	PatientDetailsRepository repo;
	
	@Autowired
	PatientRepository patientRepository;
	

	public ResponseEntity<MessageResponse> savePatientDetailsAndPatient(PatientVisitData patientVisitData){
		
			
		VitalSigns vitalSigns = new VitalSigns(patientVisitData.getVitalSigns().getHeight(), 
				patientVisitData.getVitalSigns().getWeight(),
				patientVisitData.getVitalSigns().getBloodPressure(), 
				patientVisitData.getVitalSigns().getBodyTemp(),
				patientVisitData.getVitalSigns().getRespiratinRate());
		
		Diagnosis diagnosis = new Diagnosis(patientVisitData.getDiagnosis().getDiagnosisDescription(), 
				patientVisitData.getDiagnosis().getDiagnosisText());
		
		Medication medication = new Medication(patientVisitData.getMedication().getDrugName(), 
				patientVisitData.getMedication().getMedicationText());
		
		Procedure procedure = new Procedure(patientVisitData.getProcedure().getProcedureType(), 
				patientVisitData.getProcedure().getProcedureText());
		
			
		Optional<PatientDetails> pd = repo.findByEmail("email");
		
		if(pd.isPresent()) {
			
			PatientDetails pd1 = pd.get();
			pd1.setDiagnosis(diagnosis);
			pd1.setMedication(medication);
			pd1.setProcedure(procedure);
			pd1.setVitalSigns(vitalSigns);
			repo.save(pd1);
			
			Optional<Patient> p =  patientRepository.findByEmail("email");
			Patient p1 = p.get();
			p1.setPatientDetails(pd1);
			patientRepository.save(p1);
		}
		
		return ResponseEntity.ok(new MessageResponse("PatientVisit Saved Successfully!"));
		
	}

}
