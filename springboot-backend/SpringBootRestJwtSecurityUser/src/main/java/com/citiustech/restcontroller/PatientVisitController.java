package com.citiustech.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.citiustech.repo.DiagnosisAutoCompleteRepository;
import com.citiustech.repo.MedicationSearchRepository;
import com.citiustech.repo.ProcedureSearchRepository;
import com.citiustech.response.MessageResponse;

@RestController
@RequestMapping("/visit")
public class PatientVisitController {
	
	@Autowired
	private DiagnosisAutoCompleteRepository dar;
	
	@Autowired
	private MedicationSearchRepository msr;
	
	@Autowired
	private ProcedureSearchRepository psr;
	
	@PostMapping("/patientVisit")
	public ResponseEntity<?> createUser(@RequestBody(required=true) @Autowired(required=true)PatientVisitData patientVisitData){
		
		System.out.println(patientVisitData.getVitalSigns().getBloodPressure());
	    System.out.println(patientVisitData.toString());
		
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
	
	@RequestMapping(value="search/{keyword}",method=RequestMethod.GET,produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String>> searchDiagnosis(@PathVariable("keyword") String keyword){
		try {
			
			return new ResponseEntity<List<String>>(dar.search(keyword),HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="searchMedication/{keyword1}",method=RequestMethod.GET,produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String>> searchMedication(@PathVariable("keyword1") String keyword1){
		try {
			
			return new ResponseEntity<List<String>>(msr.search(keyword1),HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="searchProcedure/{keyword2}",method=RequestMethod.GET,produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String>> searchProcedure(@PathVariable("keyword2") String keyword2){
		try {
			
			return new ResponseEntity<List<String>>(psr.search(keyword2),HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
	}

}
