import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';




@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})
export class PatientDetailsComponent implements OnInit{
  
  
  constructor(private fb: FormBuilder) {}
  
  ngOnInit() {}

    firstFormGroup:FormGroup = this.fb.group({

      // firstCtrl: ['', Validators.required]
    });
    secondFormGroup:FormGroup = this.fb.group({
    });
    thirdFormGroup:FormGroup = this.fb.group({
      
    });
    fourthFormGroup:FormGroup = this.fb.group({

    });

    doPatient(data:any){
      console.log(data);

    }
  }
  
 
  

