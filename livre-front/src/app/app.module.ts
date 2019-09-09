import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LivreListeComponent } from './components/livre-liste/livre-liste.component';
import { LivreEditComponent } from './components/livre-edit/livre-edit.component';
import { NavBarLivreComponent } from './components/nav-bar-livre/nav-bar-livre.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule} from "@angular/forms";
import { LivreRepositoryService } from './services/livre-repository.service';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { AuteurListeComponent } from './components/auteur-liste/auteur-liste.component';
import { AuteurRepositoryService } from './services/auteur-repository.service';
import { AuteurEditComponent } from './components/auteur-edit/auteur-edit.component';
import { LoginComponent } from './components/login/login.component';
import { AuthInterceptorService } from './services/auth-interceptor.service';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AppComponent,
    LivreListeComponent,
    LivreEditComponent,
    NavBarLivreComponent,
    AuteurListeComponent,
    AuteurEditComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    FormsModule,
    PaginationModule.forRoot()
  ],
  providers: [ 
    {
   provide: HTTP_INTERCEPTORS,
   useClass: AuthInterceptorService,
   multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
