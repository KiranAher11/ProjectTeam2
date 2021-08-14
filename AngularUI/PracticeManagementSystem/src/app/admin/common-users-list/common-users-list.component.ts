import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

import { analyzeAndValidateNgModules } from '@angular/compiler';




export interface PetientTableElement {

  // position: number;
  title: string;
  firstName: number;
  lastName: string;
  emailId: string;
  contactNumber: Number;
  dob: number;
  age: Number;
  gender: number;
  address: string;

}
// const ELEMENT_DATA: PetientTableElement[] = [
//   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
// ];

@Component({
  selector: 'app-common-users-list',
  templateUrl: './common-users-list.component.html',
  styleUrls: ['./common-users-list.component.css']
})
export class CommonUsersListComponent implements OnInit {
  isLoadingResults = true;
  paginatedObj: any = {};
  displayedColumns: string[] = ['serialNumber','patientId','title', 'firstName', 'lastName', 'emailId', 'contactNumber', 'dob', 'age', 'gender', 'address','action'];
  title = 'profileData';
  status:any;
  

 // public patientTableData: Array<any> = [];
  dataSource = new MatTableDataSource();


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor() {

  }
  // @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  // @ViewChild(MatSort, { static: true }) sort!: MatSort;
  ngOnInit(): void {
    //this.allProfileSVC.getAllprofiles().subscribe(data =>this.dataSource.data=data );
   // this.dataSource.data.push(property)
  
    console.log(this.dataSource)
  }

  delete_user(pateintid:any)
  {
    
     //this.deleteSvc.deleteUser(pateintid).subscribe(data=>this.status = 'Delete successful');
     this.dataSource.data = this.dataSource.data
    //  .filter(i => i !== row)
    //  .map((i, idx) => (i.position = (idx + 1), i));
    this.ngOnInit();
    
  }

}