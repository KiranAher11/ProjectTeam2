import { Component, OnInit } from '@angular/core';
import { NAV_ITEMS_LIST } from 'src/app/config/nav-items-list-config';
//import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-side-nav-item-list',
  templateUrl: './side-nav-item-list.component.html',
  styleUrls: ['./side-nav-item-list.component.css']
})
export class SideNavItemListComponent implements OnInit {

  fillerNav = NAV_ITEMS_LIST;
  role:any ;
  authUserObj: any;

  constructor() { }

  ngOnInit(): void {
    let authUser = sessionStorage.getItem('auth-user');
    if(authUser!==null)
     this.authUserObj = JSON.parse(authUser);

     this.role = this.authUserObj.role;
     console.log(this.role)
     console.log(NAV_ITEMS_LIST);

   }

}
