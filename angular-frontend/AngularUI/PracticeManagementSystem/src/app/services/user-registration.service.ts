import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }
  public userRegisteration(data: any): Observable<any>
  {
    console.warn("In user registration service",data);
   return this.http.post<any>("", data);
  }
}
