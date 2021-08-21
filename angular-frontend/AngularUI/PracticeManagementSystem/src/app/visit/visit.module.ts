import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VisitRoutingModule } from './visit-routing.module';
// import { VisitHistoryComponent } from './visit-history/visit-history.component';
// import { VisitFormComponent } from './visit-form/visit-form.component';
// import { AppointmentFormComponent } from './appointment-form/appointment-form.component';
import { SharedMaterialModule } from '../shared/shared-material/shared-material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppointmentFormComponent } from './appointment-form/appointment-form.component';
import { VisitFormComponent } from './visit-form/visit-form.component';
// import { VitalSignsComponent } from './vital-signs/vital-signs.component';

@NgModule({
  declarations: [AppointmentFormComponent, VisitFormComponent],
  imports: [
    CommonModule,
    VisitRoutingModule,
    SharedMaterialModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SharedMaterialModule
  ]
})
export class VisitModule { }
