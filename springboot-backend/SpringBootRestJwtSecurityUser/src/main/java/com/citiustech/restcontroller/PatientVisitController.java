package com.citiustech.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.model.Diagnosis;
import com.citiustech.model.Kin;
import com.citiustech.model.Medication;
import com.citiustech.model.PatientAddress;
import com.citiustech.model.PatientAllergy;
import com.citiustech.model.PatientDetails;
import com.citiustech.model.PatientDetailsData;
import com.citiustech.model.PatientVisitData;
import com.citiustech.model.Procedure;
import com.citiustech.model.VitalSigns;
import com.citiustech.response.MessageResponse;

@RestController
@RequestMapping("/visit")
public class PatientVisitController {
	
	@PostMapping("/patientVisit")
	public ResponseEntity<?> createUser(@RequestBody(required=true) @Autowired(required=true)PatientVisitData patientVisitData){
		
		//System.out.println(patientDetailsData.getPatientDetails().getFirstName());
		//System.out.println(patientDetailsData.toString());
		
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
		
		//patientDetailsRepository.save(details)
		
		return ResponseEntity.ok(new MessageResponse("PatientVisit Saved Successfully!"));
				
	}

}
