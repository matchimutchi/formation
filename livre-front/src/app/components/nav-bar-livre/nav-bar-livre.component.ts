import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/metier/user';
import {  faUser} from '@fortawesome/free-solid-svg-icons';
import { AuthManagerService } from 'src/app/services/auth-manager.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar-livre',
  templateUrl: './nav-bar-livre.component.html',
  styleUrls: ['./nav-bar-livre.component.css']
})
export class NavBarLivreComponent implements OnInit {

  faUser = faUser;

  currentUser : [boolean,User];

   constructor(private authManager : AuthManagerService,private router : Router) {
    this.currentUser = [false,null];
   }

   public logout() : void{
    this.authManager.logout();
    this.router.navigateByUrl("/login");
  }


  ngOnInit() {
    this.authManager.getUserSubjectAsObservable()
    .subscribe( u => {
      this.currentUser = u;
    });
  }

}
