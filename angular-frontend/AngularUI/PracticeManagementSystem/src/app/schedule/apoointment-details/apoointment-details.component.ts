import { DataSource } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import {Sort} from '@angular/material/sort';
import {AfterViewInit, ViewChild} from '@angular/core';
import { merge, of } from 'rxjs';
import { catchError, startWith, switchMap } from 'rxjs/operators';
import {MatSort} from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { GenerateTableObjService } from 'src/app/services/generate-table-obj.service';
// import { APPOINTMENT_DETAILS_URL } from '../../../config/URL.config';



export interface PeriodicElement {
  patientId : number;
  patientName: string;
  appointmentTitle: string;
  doctorName: string;
  appointmentTime: string;
  
  
}

@Component({
  selector: 'app-apoointment-details',
  templateUrl: './apoointment-details.component.html',
  styleUrls: ['./apoointment-details.component.css']
})

export class ApoointmentDetailsComponent  {
  isLoadingResults = true;
  paginatedObj: any = {};
  displayedColumns: string[] = ['patientId', 'patientName', 'appointmentTitle', 'doctorName','appointmentTime'];
  title="appointmentDetailsData";
  appointmentData:any = {};

  constructor( private appointmentDetailsService: GenerateTableObjService){}
    @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort!: MatSort;
  
    
   ngAfterViewInit(): void {
    // If the user changes the sort order, reset back to the first page.
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.appointmentDetailsService.getPageObject("APPOINTMENT_DETAILS_URL",
            this.sort.active, this.sort.direction, this.paginator.pageIndex, this.paginator.pageSize);
        }), catchError(() => {
          this.isLoadingResults = false;
          return of([]);
        })
      ).subscribe(data => {
        this.isLoadingResults = false;
        this.paginatedObj = data;
      });
  }
  
}
