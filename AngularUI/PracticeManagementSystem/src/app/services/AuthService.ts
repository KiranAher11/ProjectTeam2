import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AuthService{

    public email: any;
    public password: any;
constructor(private http: HttpClient){

}
  login(email:any,password:any){

    return this.http.get(environment.hosturl + '/api/auth/login',{
        headers:{authorization:this.createBasicAuthToken(email,password)}}).pipe(map((res:any)=>{
            this.email= email;
            this.password = password;
            this.registrationSuccessfullogin(email,password)


        }))
  };
  createBasicAuthToken(email:string,password:string){
      return ' Basic' + window.btoa(email + ":" +password)
  }

  registrationSuccessfullogin(email:string,password:string){

  }

}