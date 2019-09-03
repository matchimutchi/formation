import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from "@angular/common/http";
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


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ProduitListeComponent,
    ProduitDetailComponent,
    ImageDetailComponent,
    ImageListeComponent,
    ImageUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FileUploadModule,
    HttpClientModule,
    PaginationModule.forRoot(),
    NgStringPipesModule,
    FontAwesomeModule,
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
