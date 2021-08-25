import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { VisitFormService } from './visit-form.service';

@Component({
  selector: 'app-visit-form',
  templateUrl: './visit-form.component.html',
  styleUrls: ['./visit-form.component.css']
})
export class VisitFormComponent implements OnInit{
  step:any = 1;
  result:any=null;

  diagnosisDescription = new FormControl();
  keyword: any;
  filteredOptions!: any[];
 
  
  constructor(private fb: FormBuilder,private http: HttpClient,private VisitService: VisitFormService) {}

  multistep = new FormGroup({
    vitalSigns : new FormGroup({
      height : new FormControl(''),
      weight : new FormControl(''),
      bloodPressure : new FormControl(''),
      bodyTemp : new FormControl(''),
      respiratinRate : new FormControl('')
     }),
     diagnosis: new FormGroup({
      diagnosisDescription : new FormControl(''),
      diagnosisText : new FormControl('')
     }),
     medication : new FormGroup({
      drugName : new FormControl(''),
      medicationText : new FormControl('')
     }),
     procedure : new FormGroup({
      ProcedureType : new FormControl(''),
      procedureText : new FormControl('')
     }),
      email : new FormGroup({
      email : new FormControl('')
     })
  })

  firstFormGroup:FormGroup = this.fb.group({

    // firstCtrl: ['', Validators.required]

  });
  secondFormGroup:FormGroup = this.fb.group({
    
  });
  thirdFormGroup:FormGroup = this.fb.group({
    
  });
  fourthFormGroup:FormGroup = this.fb.group({

  });
  fifthFormGroup:FormGroup = this.fb.group({

  });
  
  ngOnInit():void {

    // this.filteredOptions = this.diagnosisDescription.valueChanges
    // .pipe(
    //   startWith(''),
    //   map(value => this._filter(value))
    // );
  }

  // search(event){
  //   this.filteredOptions = [];
  //   this.VisitService.search(this.keyword).subscribe((res=>{
  //     this.filteredOptions = res;
  //   })
      
  //   );
  // }

  doPatientVisit(data:any){
    console.log(data);
      return this.http.post("http://localhost:9900/api/visit/patientVisit",data,{responseType: 'text' as 'json'}).subscribe((result)=>{
      console.log("result",result);
  }) 
}
 
// private _filter(value: string): string[] {
//   const filterValue = value.toLowerCase();

//   return this.keyword.filter((option: string) => option.toLowerCase().includes(filterValue));
// }
}