import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import {EditProfileComponent} from './edit-profile/edit-profile.component';
import {PatientDetailsComponent} from '../usermangment/patient-details/patient-details.component';
import { HospitalUserEditProfileComponent } from './hospital-user-edit-profile/hospital-user-edit-profile.component';

const routes: Routes = [
  {
    path: 'profile', component: ProfileComponent,
    
  },
  {
    path: 'edit_profile',
    component: EditProfileComponent
  },
  {
    //path: 'patient_details',
    path: 'patientDetails',
    component: PatientDetailsComponent
  },
  {
    path: 'hospital_user_edit_profile',
    component: HospitalUserEditProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsermangmentRoutingModule { }
