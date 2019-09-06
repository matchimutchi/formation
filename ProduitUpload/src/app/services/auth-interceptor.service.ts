import { Injectable } from '@angular/core';
import { AuthManagerService } from './auth-manager.service';
import { Router } from '@angular/router';
import { HttpInterceptor,HttpRequest,HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import {catchError} from"rxjs/operators";
import { error } from 'util';
@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{




  constructor(private authManager : AuthManagerService,
              private router : Router) { }


                
  intercept(req:HttpRequest<any>,next:HttpHandler):Observable<HttpEvent<any>>{

    //avant que la requete part au back-end
    if(this.authManager.isLoggedIn()){
      req = req.clone({ setHeaders : 
        {Authorization: `Basic ${this.authManager.getCredentials()}`}
      });
    }
    return next.handle(req).pipe(catchError((error,caught)=>{

      console.log(error);
      //es ce que c'est une erreur liée a une réponse du back end
      if(error instanceof HttpErrorResponse){
        let resp : HttpErrorResponse = error;
        if(resp.status == 401){
          //on doit s authentifier
          this.router.navigateByUrl("/login");
        }
      }
      return Observable.throw(error);
    }));
  }

 
  
}
