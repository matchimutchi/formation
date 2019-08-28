import { Component, OnInit } from '@angular/core';
import { FilmRepositoryService } from 'src/app/services/film-repository.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Film } from 'src/app/metier/Film';

@Component({
  selector: 'app-film-edit',
  templateUrl: './film-edit.component.html',
  styleUrls: ['./film-edit.component.css']
})
export class FilmEditComponent implements OnInit {

  //-----------------------DECLARATION D UN OBJET-------------------------
  public editFIlm : Film;
  //declaration des Class dans le constructeur constructeurs 
  constructor(private filmRepository : FilmRepositoryService,private activeRoute : ActivatedRoute,private router : Router) {


   }


  //-----------------------INITIALISER LE FORMULAIRE-------------------------
  ngOnInit() {
    this.editFIlm = new Film(0,"",0,new Date());
    this.activeRoute.params.subscribe( params => {
      let id = Number(params['id']);
      console.log("recu id film -> " + id);

      if(id != 0){
        //-----------------------AFFICHER TT LES ELEMENTS-------------------------
        //then = QUAND LA PROMESE EST RESOLU on affiche le resultat
        this.filmRepository.getFilmById(id).then( f => this.editFIlm = f);
      }
    });
  }




 //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
  public sauverFilm() : void{
    console.log("sauvegarde de ");
    console.log(this.editFIlm);


    //appeler le filmRepository pour la sauvegarde
    //then = rappeler quand le serveur a repondu
    this.filmRepository.saveFilm(this.editFIlm).then(f =>{
      
      console.log("Sauvegarde OK");
      console.log(f);

      //-----------------------REDIRECTION VERS LISTE-------------------------
      this.router.navigateByUrl('/liste');
    });
  }

}
