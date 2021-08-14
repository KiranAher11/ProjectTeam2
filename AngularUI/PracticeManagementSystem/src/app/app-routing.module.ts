import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [

  
  {
    path : '',
    component : AppComponent,
    children : [
      {
        path : '',
        component : LoginComponent
      }
    ]
  },
   { path: 'user-registration', component: UserRegistrationComponent },
   //{ path: 'home', component: NavigationComponent },
   { path: 'patient', loadChildren: () => import(`./patient/patient.module`).then(m => m.PatientModule)},
   { path: 'forgot-password', component: ForgotPasswordComponent },
   { path: 'change-password', component: ChangePasswordComponent },
   {path: 'core', loadChildren: () => import('./core/core.module').then(c => c.CoreModule)}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
