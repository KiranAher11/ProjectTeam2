import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientRoutingModule } from './patient-routing.module';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatStepperModule} from '@angular/material/stepper';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    PatientDetailsComponent
  ],
  imports: [
    CommonModule,
    PatientRoutingModule,
    MatRadioModule,
    MatDatepickerModule,
    MatInputModule,
    MatStepperModule,
    MatSelectModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
  
    
    
  ],
providers: [],
bootstrap: [PatientDetailsComponent]
})
export class PatientModule { }
