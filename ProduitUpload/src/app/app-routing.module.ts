import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProduitListeComponent } from './components/produit/produit-liste/produit-liste.component';
import { ProduitDetailComponent } from './components/produit/produit-detail/produit-detail.component';


const routes: Routes = [
  {path: 'produit', component: ProduitListeComponent},
  {path: 'details/:id', component: ProduitDetailComponent},
  {path: '', redirectTo: 'produits', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
