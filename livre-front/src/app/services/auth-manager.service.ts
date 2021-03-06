import { Injectable } from '@angular/core';
import { User } from '../metier/user';
import { Subject, VirtualTimeScheduler, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthManagerService {

  private currentUser : User;
  private userSubject : Subject<[boolean,User]>;

  
  public getCurrentUser():User{
    return this.currentUser;
  }

  public setCurrentUser(user : User): void{
    this.currentUser = user;
    this.userSubject.next([true,user]);
  }

  //----------------------------DECONNEXION--------------------------
  public logout(){
    this.currentUser = null;
    this.userSubject.next([false,null]);
  }

  public getCredentials(): string{
    return window.btoa(this.currentUser.username + ":" + this.currentUser.password);
  }

  //----------------------------CONNEXION - DECONNEXION--------------------------
  public isLoggedIn() : boolean{
    if(this.currentUser ==  null){
      return false;
    }else{
      return true;
    }
  }

  public getUserSubjectAsObservable(): Observable<[boolean,User]>{
    return this.userSubject.asObservable();
  }


  constructor() { 
    this.currentUser = null;
    this.userSubject = new Subject<[boolean,User]>();
  }
}
