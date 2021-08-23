import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

//import { Response } from '@angular/http'; 
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class VisitFormService {

  authUserObj: any;

  BASE_URL:string = 'http://localhost:9900/api/visit/'
 

  constructor(private http: HttpClient,private authSrc:AuthService) { }

  search(keyword:any):any{
    return this.http.get(this.BASE_URL + 'search/' , keyword);
        //  .pipe(map((res:Response)=>res.json()));
  }

}
