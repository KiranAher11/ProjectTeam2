import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';




@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})
export class PatientDetailsComponent implements OnInit{
  
 
  
  constructor(private fb: FormBuilder,private http: HttpClient) {}
  
  ngOnInit() {}

    firstFormGroup:FormGroup = this.fb.group({

      // firstCtrl: ['', Validators.required]
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
    });
    secondFormGroup:FormGroup = this.fb.group({
    });
    thirdFormGroup:FormGroup = this.fb.group({
      
    });
    fourthFormGroup:FormGroup = this.fb.group({

    });

    doPatient(data:any){
      console.log(data);
      return this.http.post("http://localhost:9900/api/auth/patient",data,{responseType: 'text' as 'json'}).subscribe((result)=>{
      console.log("Result",result);
}) 

   }
}