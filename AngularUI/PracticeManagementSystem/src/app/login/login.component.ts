import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';

import {AuthService} from '../services/AuthService';
import { HttpClient } from '@angular/common/http';

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
  constructor(private fb:FormBuilder,private authService:AuthService,private http: HttpClient) {

   }

  ngOnInit(){
  }
      loginForm:FormGroup = this.fb.group({
      email :['',[Validators.required,Validators.email]],
      password :['',[Validators.required,Validators.minLength(6)]]
      })
    

      doLogin(data:any){
         console.log(data);
         return this.http.post("http://localhost:9900/api/auth/login",data,{responseType: 'text' as 'json'}).subscribe((result)=>{
         console.log("Result",result);
  }) 

      }
  }
  


