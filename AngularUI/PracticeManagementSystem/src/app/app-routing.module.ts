import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
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

   { path: 'home', component: NavigationComponent },
   { path: 'patient', loadChildren: () => import(`./patient/patient.module`).then(m => m.PatientModule)},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
