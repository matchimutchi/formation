import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProduitListeComponent } from './components/produit/produit-liste/produit-liste.component';
import { ProduitDetailComponent } from './components/produit/produit-detail/produit-detail.component';
import { ImageListeComponent } from './components/image/image-liste/image-liste.component';
import { ImageDetailComponent } from './components/image/image-detail/image-detail.component';
import { ImageUploadComponent } from './components/image/image-upload/image-upload.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  {path: 'produit', component: ProduitListeComponent},
  {path: 'edit/:id', component: ProduitDetailComponent},
  {path: 'images', component: ImageListeComponent},
  {path: 'details/:id', component: ImageDetailComponent},
  {path: 'upload', component: ImageUploadComponent},
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: 'produit', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
