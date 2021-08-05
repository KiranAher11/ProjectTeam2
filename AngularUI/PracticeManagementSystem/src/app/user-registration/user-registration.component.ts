import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit {

  role = 'user';


  constructor(private http: HttpClient) { }
  optionsSelect: Array<any> = [];

    ngOnInit() {


  }
  hide = true;

onSubmit(data:any){
  console.log(data);
  return this.http.post("http://localhost:9900/api/auth/register",data,{responseType: 'text' as 'json'}).subscribe((result)=>{
     console.log("Result",result);
  }) 
} 
}
