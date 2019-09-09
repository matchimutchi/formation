import { Component, OnInit } from '@angular/core';
import { faShoppingBasket, faUser} from '@fortawesome/free-solid-svg-icons';
import { AuthManagerService } from 'src/app/services/auth-manager.service';
import { User } from 'src/app/metier/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  faShoppingBasket = faShoppingBasket;
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
