import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FileUploadModule } from "ng2-file-upload";
import { NavBarComponent } from "./components/nav-bar/nav-bar.component";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { NgStringPipesModule } from 'angular-pipes';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import { ModalModule } from 'ngx-bootstrap/modal';
import { FormsModule } from '@angular/forms';
import { ProduitListeComponent } from './components/produit/produit-liste/produit-liste.component';
import { ProduitDetailComponent } from './components/produit/produit-detail/produit-detail.component';
import { ImageDetailComponent } from './components/image/image-detail/image-detail.component';
import { ImageListeComponent } from './components/image/image-liste/image-liste.component';
import { ImageUploadComponent } from './components/image/image-upload/image-upload.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProgressbarModule } from 'ngx-bootstrap/progressbar';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { LoginComponent } from './components/login/login.component';
import { AuthInterceptorService } from './services/auth-interceptor.service';




@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ProduitListeComponent,
    ProduitDetailComponent,
    ImageDetailComponent,
    ImageListeComponent,
    ImageUploadComponent,
    LoginComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FileUploadModule, 
    PaginationModule.forRoot(),
    NgStringPipesModule,
    FontAwesomeModule,
    ModalModule.forRoot(),
    BrowserAnimationsModule,
    ProgressbarModule.forRoot(),
    CarouselModule.forRoot()
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
