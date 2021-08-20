import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';




@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit{
  step:any = 1;
 
  
  constructor(private fb: FormBuilder,private http: HttpClient) {}

  multistep = new FormGroup({
    patientDetails : new FormGroup({
      title : new FormControl(''),
      firstName : new FormControl(''),
      lastName : new FormControl(''),
      dateOfBirth : new FormControl(''),
      age : new FormControl(''),
      gender : new FormControl(''),
      race : new FormControl(''),
      ethnicity : new FormControl(''),
      languagesKnown : new FormControl(''),
      email : new FormControl(''),
      contactNumber : new FormControl('')
     }),
     address: new FormGroup({
      street : new FormControl(''),
      city : new FormControl(''),
      state : new FormControl(''),
      country : new FormControl(''),
      postalCode : new FormControl('')
     }),
     kin : new FormGroup({
      firstName : new FormControl(''),
      lastName : new FormControl(''),
      relationship : new FormControl(''),
      email : new FormControl(''),
      contactNumber : new FormControl('')
     }),
     patientAllergy : new FormGroup({
      allergyRadio : new FormControl(''),
      allergyId : new FormControl(''),
      allergyType : new FormControl('')
     })
  })

  firstFormGroup:FormGroup = this.fb.group({

    // firstCtrl: ['', Validators.required]

  });
  secondFormGroup:FormGroup = this.fb.group({
    
  });
  thirdFormGroup:FormGroup = this.fb.group({
    
  });
  fourthFormGroup:FormGroup = this.fb.group({

  });
  
  ngOnInit() {}

    doPatient(data:any){
    console.log(data);
      return this.http.post("http://localhost:9900/api/details/patient",data,{responseType: 'text' as 'json'}).subscribe((result)=>{
      console.log("Result",result);
}) 

   }
}