import { Component, OnInit } from '@angular/core';
import { AuthManagerService } from 'src/app/services/auth-manager.service';
import { Router } from '@angular/router';
import { User } from 'src/app/metier/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authManager : AuthManagerService, private router : Router) { 
    
  }

  userLogin : User;

  ngOnInit() {
    this.userLogin = new User("","");
  }

  public logMeIn(): void
{
  this.authManager.setCurrentUser(this.userLogin);
  this.router.navigateByUrl("");
}
}
