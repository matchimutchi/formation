import { Component, OnInit } from '@angular/core';
import { Auteur } from 'src/app/metier/Auteur';
import { AuteurRepositoryService } from 'src/app/services/auteur-repository.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-auteur-edit',
  templateUrl: './auteur-edit.component.html',
  styleUrls: ['./auteur-edit.component.css']
})
export class AuteurEditComponent implements OnInit {

  public editAuteur : Auteur;



  constructor(private auteurRepository : AuteurRepositoryService,private activeRoute : ActivatedRoute,private router : Router) { }

  ngOnInit() {


    this.editAuteur = new Auteur(0,"","");
    this.activeRoute.params.subscribe( params => {
      let id = Number(params['id']);
      console.log("recu id auteur -> " + id);

      if(id != 0){
        //-----------------------AFFICHER TT LES ELEMENTS-------------------------
        this.auteurRepository.getAuteurById(id).then( l => this.editAuteur = l);
      }
    });

  }

   //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
   public sauverAuteur() : void{
    console.log("sauvegarde de ");
    console.log(this.editAuteur);

    this.auteurRepository.saveAuteur(this.editAuteur).then(a =>{
      
      console.log("Sauvegarde OK");
      console.log(a);


      
      //-----------------------REDIRECTION VERS AUTEURliste-------------------------
      this.router.navigateByUrl('/listeauteur');
    });
  }
}
