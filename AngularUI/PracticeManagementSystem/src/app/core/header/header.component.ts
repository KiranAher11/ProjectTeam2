import { Component, OnInit, ChangeDetectorRef, OnDestroy } from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog'
import { Router } from '@angular/router';
import { SideNavService } from 'src/app/services/side-nav.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  userId:any;
  authUserObj: any;
  role:any;
  public profileData: Array<any> = [];
  patient:any

  constructor( private sideNavService: SideNavService, private dialog: MatDialog,
    private router:Router
    ) {
  }

  ngOnInit(): void {
    let authUser = sessionStorage.getItem('auth-user');
    if(authUser!==null)
     this.authUserObj = JSON.parse(authUser);
     this.userId = this.authUserObj.userId;
     this.role = this.authUserObj.role;
     //console.log(this.userId)
    //  if(this.role=='patient')
    //  this.profileSVC.get_patient_profile(this.userId).subscribe((data: any) => this.profileData.push(data)); 
    //  else
    //  this.profileSVC.get_hospital_user_profile(this.userId).subscribe((data: any) => this.profileData.push(data)); 
  
    }

  clickMenu(): void{
    this.sideNavService.toggle();
  }

  ngOnDestroy(): void {
  }
  // openDialog(): void {
  //   const dialogRef = this.dialog.open(ProfileComponent, {
  //     width: '640px'
      
  //   });
  //   dialogRef.afterClosed().subscribe(result => {
  //     if(this.role=='patient')
  //     this.router.navigate(["/core/usermanagement/edit_profile"]);
  //     else
  //     this.router.navigate(["core/usermanagement/hospital_user_edit_profile"]);
  //   });
  // }

}


