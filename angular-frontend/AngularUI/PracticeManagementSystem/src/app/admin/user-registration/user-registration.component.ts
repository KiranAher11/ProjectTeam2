import { Component, OnInit } from '@angular/core';
import {MustMatch} from '../user-registration/user-registration-validator';
import {  FormGroup, Validators,FormBuilder, FormGroupDirective} from '@angular/forms';
import {ViewChild} from '@angular/core'
import {MatSnackBar} from '@angular/material/snack-bar';
import { UserRegistrationService } from 'src/app/services/user-registration.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
 public maxDate = new Date()
 alert:boolean=false;

 passhide = true;
confpasshide=true;

 public error: string = "";
 userRegisterForm!: FormGroup;
//  matcher = new MyErrorStateMatcher();
//  @ViewChild(FormGroupDirective) formDirective: FormGroupDirective;
 
 
 constructor(private formBuilder: FormBuilder,private regSvc : UserRegistrationService,private _snackBar: MatSnackBar) {
   

 }
 userRegister():void{
  // console.warn(this.userRegisterForm.value)
  this.regSvc.userRegisteration(this.userRegisterForm.value).subscribe((result)=>{console.warn(result)
  this.alert=true})
  if(this.userRegisterForm.valid){
    //this.formDirective.resetForm(); 
    this.openSnackBar()
  }
  // this.userRegisterForm.reset({})
 }

//  closeAlert(){
//   this.alert=false;
// }

openSnackBar() {
  this._snackBar.open('Register Successfully!!', 'End', {
    duration: 500,
  
  });
}



 
 ngOnInit(): void {
  this.userRegisterForm = this.formBuilder.group({
    title: ['', Validators.required],
    firstName: ['', [ Validators.required, Validators.minLength(3)]],
    lastName: ['', [ Validators.required, Validators.minLength(3)]],
    contactNumber: ['', [Validators.required, Validators.pattern('[789][0-9]{9}')]],
    emailId: ['', [Validators.required, Validators.email]],
    dob: ['', Validators.required],
    gender: ['', Validators.required],
    experience :['',Validators.required],
    address: ['', Validators.required],
    specialization: ['', [ Validators.required, Validators.minLength(3)]]
   
});
}

get f() { return this.userRegisterForm.controls; }
}
