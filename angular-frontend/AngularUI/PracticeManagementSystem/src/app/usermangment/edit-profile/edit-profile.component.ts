import { Component, OnInit } from '@angular/core';
import {MatAccordion} from '@angular/material/expansion';
import { ViewChild } from '@angular/core';
import { FormControl, FormGroup, FormBuilder,Validators,ReactiveFormsModule,FormArray,FormGroupDirective } from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import { ProfileService } from 'src/app/services/profile.service';
import { PatientDetailsService } from 'src/app/services/patient-details.service';



interface Race {
  value: string;
  viewValue: string;
  }
  
  interface Ethnisity {
  value: string;
  viewValue: string;
  }

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  // matcher = new MyErrorStateMatcher();
  editForm!: FormGroup;
  public maxDate = new Date();
  selectedLanguageList:any[]=[];
  public emergencyContactInfoList: any;
  public allergys: any;
  public patientData: Array<any> = [];
  public allergyData: any = [];
  public langugesData: any = [];
  @ViewChild(MatAccordion) accordion: any ;
  @ViewChild(FormGroupDirective) formDirective: any;
  showMsg: boolean = false;
  role:any|null;
  authUserObj: any;
  userId:any;

  races: Race[] = [
    { value: 'American Indian ', viewValue: 'American Indian ' },
    { value: 'Asian', viewValue: 'Asian' },
    { value: 'African American', viewValue: 'African American' },
    { value: 'White', viewValue: 'White' },
    { value: 'Native Hawaiian', viewValue: 'Native Hawaiian' }
  ];
  
  ethnicitys: Ethnisity[] = [
    { value: 'Americans', viewValue: 'Americans' },
    { value: 'Indian people', viewValue: 'Indian people' },
    { value: 'British people', viewValue: 'British people' },
    { value: 'Mexicans', viewValue: 'Mexicans' },
    { value: 'Russian', viewValue: 'Russian' },
    { value: 'Greeks', viewValue: 'Greeks' },
    { value: 'Germans', viewValue: 'Germans' },
    { value: 'Australians', viewValue: 'Australians' },
    { value: 'Bangladeshi', viewValue: 'Bangladeshi' }
  ];

  constructor(private formBuilder: FormBuilder,private profileSVC: ProfileService, 
    private patientSvc: PatientDetailsService,private _snackBar: MatSnackBar) { 
    this.editForm = this.formBuilder.group({
      title: [''],
      firstName: [''],
      lastName: [''],
      contactNumber: [''],
      emailId: [''],
      dob: [''],
      age: ['',],
      gender: [''],
      race: [''],
      ethnicity: [''],
      address: [''],
      allergys: this.formBuilder.array([this.createAllergy()]),
      languageList:[this.selectedLanguageList],
      emergencyContactInfoList: this.formBuilder.array([this.createEmergencyContact()])
      });

  }

  submitForm(){
    let authUser = sessionStorage.getItem('auth-user');
      if(authUser!==null)
      this.authUserObj = JSON.parse(authUser);
  
      this.role = this.authUserObj.role;
      this.userId=this.authUserObj.userId
    this.patientSvc.patient(this.editForm.value,this.userId).subscribe((result) => { console.warn(result); });
    this.editForm.reset();
    this.openSnackBar()
    
  }

  openSnackBar() {
    this._snackBar.open('Data Saved Successfully!!', 'End', {
      duration: 500,
    
    });
  }

  ngOnInit(): void {
   
    let authUser = sessionStorage.getItem('auth-user');
    if(authUser!==null)
     this.authUserObj = JSON.parse(authUser);
  
     this.role = this.authUserObj.role;
     this.userId=this.authUserObj.userId
     // this.profileSVC.getprofiles().subscribe(data => this.patientData.push(data));
     this.profileSVC.get_patient_profile(this.userId).subscribe(data => this.patientData.push(data)); 
      this.profileSVC.getAllergys().subscribe(data=> this.allergyData=data);
      this.profileSVC.getLanguages().subscribe(data=> this.langugesData=data);

      console.log(this.patientData)
      
      //this.addEmergencyContact();
      //this.addEmergencyContact();

      //this.addAllergy();
    
      
  
  }

  createAllergy(): FormGroup {
    return this.formBuilder.group({
      allergyName: [''],
      is_fatal: [''],
    });

  }

  addAllergy(): void {
    this.allergys = this.editForm.get('allergys') as FormArray;
    this.allergys.push(this.createAllergy());
  }

  get allergyControls() {
    return (<any>this.editForm.get('allergys'))['controls'];
  }
  

  //  Add Emergency Contact to formGroup
  createEmergencyContact(): FormGroup {
    return this.formBuilder.group({
      kinFirstName: [''],
      kinLastName: [''],
      kincontactNumber: [''],
      kinEmail: [''],
      kinAddress: [''],
      relationship: [''],
      portalAccess: ['']
    });
  }

  addEmergencyContact(): void {
    this.emergencyContactInfoList =this.editForm.get('emergencyContactInfoList') as FormArray;
    this.emergencyContactInfoList.push(this.createEmergencyContact());  
    
  }

  get emergencyListControls() {
    return (<any>this.editForm.get('emergencyContactInfoList'))['controls'];

  }

  getLanguagesList(lang:any){

    this.selectedLanguageList.push(lang);

  }
  

}
