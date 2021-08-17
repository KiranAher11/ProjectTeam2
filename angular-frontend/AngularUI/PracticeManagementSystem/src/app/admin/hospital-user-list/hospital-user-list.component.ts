import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-hospital-user-list',
  templateUrl: './hospital-user-list.component.html',
  styleUrls: ['./hospital-user-list.component.css']
})
export class HospitalUserListComponent implements OnInit {

  isLoadingResults = true;
  paginatedObj: any = {};
  displayedColumns: string[] = ['serialNumber','userId','title', 'firstName', 'lastName', 'emailId', 'contactNumber', 'dob', 'gender', 'address','action'];
  title = 'profileData';
  status:any;
  
 // public patientTableData: Array<any> = [];
  dataSource = new MatTableDataSource();

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor() {}

  // @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  // @ViewChild(MatSort, { static: true }) sort!: MatSort;
  ngOnInit(): void {
    //this.allProfileSVC.getAllHospitalUserprofiles().subscribe(data =>this.dataSource.data=data );
   //this.dataSource.data.push(property)
  
   console.log(this.dataSource)
  }

  delete_user(userId:any)
  {
    
     //this.deleteSvc.deleteHospitalUser(userId).subscribe(data=>this.status = 'Delete successful');
     this.dataSource.data = this.dataSource.data
    //  .filter(i => i !== row)
    //  .map((i, idx) => (i.position = (idx + 1), i));
    this.ngOnInit();
    
  }
}
