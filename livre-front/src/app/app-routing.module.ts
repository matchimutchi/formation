import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LivreListeComponent } from './components/livre-liste/livre-liste.component';
import { LivreEditComponent } from './components/livre-edit/livre-edit.component';
import { AuteurListeComponent } from './components/auteur-liste/auteur-liste.component';
import { AuteurEditComponent } from './components/auteur-edit/auteur-edit.component';


const routes: Routes = [
{path:"liste",component : LivreListeComponent},
{path: 'edit/:id', component: LivreEditComponent},
{path:"listeauteur",component : AuteurListeComponent},
{path: 'editAuteur/:id', component: AuteurEditComponent},
{path: '', redirectTo: '/liste',pathMatch:'full'} 
  
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
