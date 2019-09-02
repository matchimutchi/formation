import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LivreListeComponent } from './components/livre-liste/livre-liste.component';
import { LivreEditComponent } from './components/livre-edit/livre-edit.component';
import { NavBarLivreComponent } from './components/nav-bar-livre/nav-bar-livre.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from "@angular/forms";
import { LivreRepositoryService } from './services/livre-repository.service';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { AuteurListeComponent } from './components/auteur-liste/auteur-liste.component';
import { AuteurRepositoryService } from './services/auteur-repository.service';
import { AuteurEditComponent } from './components/auteur-edit/auteur-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    LivreListeComponent,
    LivreEditComponent,
    NavBarLivreComponent,
    AuteurListeComponent,
    AuteurEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    PaginationModule.forRoot()
  ],
  providers: [ 
    LivreRepositoryService,
   AuteurRepositoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
