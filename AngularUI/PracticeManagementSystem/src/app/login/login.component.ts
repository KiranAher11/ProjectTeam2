import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';

import {AuthService} from '../services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  email:any;
  password:any;
  errorMessage = "Invalid Credentials";
  successMessage:any;
  invalidLogin = false;
  loginSuccess = false;
  hide: boolean=false;
  constructor(private fb:FormBuilder,private authService:AuthService) {

   }

  ngOnInit(){
  }
    loginForm:FormGroup = this.fb.group({
      email :['',[Validators.required,Validators.email]],
      password :['',[Validators.required,Validators.minLength(6)]]
      })
    
      onLogin(){
       this.authService.login(this.email,this.password).subscribe((result:any) => {
         this.invalidLogin=false;
         this.loginSuccess = true;
         this.successMessage = "Login Successful";
         
       },() => {
            this .invalidLogin = true;
            this.loginSuccess = false;

       });
        console.log(this.loginForm.value);
        console.log("clicked");
      }
      
  }
  


