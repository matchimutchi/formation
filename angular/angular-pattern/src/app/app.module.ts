import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProduitFormComponent } from './components/produit-form/produit-form.component';
import { PanierListeComponent } from './components/panier-liste/panier-liste.component';
import { PanierSummaryComponent } from './components/panier-summary/panier-summary.component';
import { PanierCoutComponent } from './components/panier-cout/panier-cout.component';

@NgModule({
  declarations: [
    AppComponent,
    ProduitFormComponent,
    PanierListeComponent,
    PanierSummaryComponent,
    PanierCoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
