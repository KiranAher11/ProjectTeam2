import { Component } from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {BreakpointObserver} from '@angular/cdk/layout';
import {StepperOrientation} from '@angular/material/stepper';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';


@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})
export class PatientDetailsComponent{

  firstFormGroup = this.fb.group({
    firstCtrl: ['', Validators.required]
  });
  secondFormGroup = this.fb.group({
    secondCtrl: ['', Validators.required]
  });
  thirdFormGroup = this.fb.group({
    thirdCtrl: ['', Validators.required]
  });
  fourthFormGroup = this.fb.group({
    fourthCtrl: ['', Validators.required]
  })
  stepperOrientation: Observable<StepperOrientation>;

  constructor(private fb: FormBuilder, breakpointObserver: BreakpointObserver) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)')
      .pipe(map(({matches}) => matches ? 'horizontal' : 'vertical'));
  }
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);
}
  

