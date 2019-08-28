import { Component, OnInit } from '@angular/core';
import { Livre } from 'src/app/metier/Livre';
import { LivreRepositoryService } from 'src/app/services/livre-repository.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuteurRepositoryService } from 'src/app/services/auteur-repository.service';
import { Auteur } from 'src/app/metier/Auteur';
import { VirtualTimeScheduler } from 'rxjs';

@Component({
  selector: 'app-livre-edit',
  templateUrl: './livre-edit.component.html',
  styleUrls: ['./livre-edit.component.css']
})
export class LivreEditComponent implements OnInit {

  public editLivre : Livre;


  public auteurs : Auteur[];


  constructor(private livreRepository : LivreRepositoryService,
              private auteurRepository : AuteurRepositoryService,
              private activeRoute : ActivatedRoute,
              private router : Router) { }

  ngOnInit() {

 
    this.editLivre = new Livre(0,"",0,"",new Date());
    this.editLivre.auteur = new Auteur(0,"","");
    this.activeRoute.params.subscribe( params => {
      let id = Number(params['id']);
      console.log("recu id Livre -> " + id);

      if(id != 0){
        //-----------------------AFFICHER TT LES ELEMENTS-------------------------
        this.livreRepository.getLivreById(id).then( l => this.editLivre = l);
      }
    });

    this.auteurRepository.getListeAuteurs().then( p => this.auteurs = p.content);



  }

   //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
   public sauverLivre() : void{
    console.log("sauvegarde de ");
    console.log(this.editLivre);

    this.livreRepository.saveLivre(this.editLivre).then(l =>{
      
      console.log("Sauvegarde OK");
      console.log(l);
      //-----------------------REDIRECTION VERS LISTE-------------------------
      this.router.navigateByUrl('/liste');
    });

  }


}
