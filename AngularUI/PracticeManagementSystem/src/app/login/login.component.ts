import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { TokenStorageService } from '../services/token-storage.service';
import { AuthService } from '../services/auth.service';
import { LOGIN_URL } from '../config/URL.config';
// import { SnackbarAlertService } from '../services/snackbar-alert.service';

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

  constructor(private router:Router,
    private tokenStorage: TokenStorageService, 
    //  private alert: SnackbarAlertService,
    private http: HttpClient,
    private fb: FormBuilder,
    private authService: AuthService ) {}

  ngOnInit(){}

  loginForm:FormGroup = this.fb.group({
  email :['',[Validators.required,Validators.email]],
  password :['',[Validators.required,Validators.minLength(6)]],
  isEmployee :['']
  })
  
  doLogin(data:any){
    console.log(data);
    return this.http.post(LOGIN_URL,data,
    { 
      responseType: 'text' as 'json'}).subscribe(
      data => {
        //this.tokenStorage.saveToken(data.token);
        let res:any;
        this.tokenStorage.saveUser(data);
        console.log(data)
        
        // if(data.roles=='nurse' || data.role == 'physician') {
        //   this.router.navigate(['/core/inbox/sharedinbox']);
        // } else if (data.role== 'admin'){
        //   this.router.navigate(['/core/admin/hospitalUserList']);
        // } 
         //if (data.roles == 'ROLE_PATIENT') {
          console.log("11111111111111111");
          this.router.navigate(['/core']);
        
      },
      err => {
        // this.alert.openSnackBar(err.error.message, '', 3000);
        console.log(err);
      });
  }

  checkUser(e: any) {
    if (e.checked)
      this.loginForm.value.isEmployee = true;
    else
    this.loginForm.value.isEmployee = false;
  }
}