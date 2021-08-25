import { Component, OnInit } from '@angular/core';
import { NAV_ITEMS_LIST } from 'src/app/config/nav-items-list-config';
import { TokenStorageService } from 'src/app/services/token-storage.service';
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
  constructor(private tkn:TokenStorageService) { }

  ngOnInit(): void {
    let authUser = sessionStorage.getItem("TOKEN_KEY");
  console.log("!!!!!!!"+authUser);

    if(authUser!==null)
     this.authUserObj = JSON.parse(authUser);

     this.role = this.authUserObj.role;
     console.log("!!!!!!!333333333"+this.role);


     console.log(this.role)
     console.log(NAV_ITEMS_LIST);

     console.log("111"+this.fillerNav);

     //console.log("222"+this.fillerNav.permitTo.indexOf(role)
   }


}
