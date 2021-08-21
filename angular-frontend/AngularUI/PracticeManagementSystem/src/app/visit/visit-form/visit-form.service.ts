import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class VisitFormService {

  authUserObj: any;
 

  constructor(private http: HttpClient,private authSrc:AuthService) { }

  getPatientDetails(patientData:any):any{
    console.log('patient Details');
    console.log(patientData);

    return this.http.get("http://localhost:9900/api/aut/usermanagement/patient_details",patientData);

  }

}
