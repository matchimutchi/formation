import { Injectable } from '@angular/core';
import { AuthManagerService } from './auth-manager.service';
import { Router } from '@angular/router';
import { HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{

  constructor(private authManager : AuthManagerService,private router : Router) { }

  intercept(req:HttpRequest<any>,next:HttpHandler):Observable<HttpEvent<any>>{


    if(this.authManager.isLoggedIn()){
      req = req.clone({ setHeaders : 
        {Authorization: `Basic ${this.authManager.getCredentials()}`}
      });
    }
    return next.handle(req).pipe(catchError((error,caught)=>{
      console.log(error);
      if(error instanceof HttpErrorResponse){
        let resp : HttpErrorResponse = error;
        if(resp.status == 401 || resp.status == 403){
          this.router.navigateByUrl("/login");
        }
      }
      return Observable.throw(error);
    }));
  }
}
