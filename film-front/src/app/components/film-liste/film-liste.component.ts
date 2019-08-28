import { Component, OnInit, OnDestroy } from '@angular/core';
import { FilmRepositoryService } from 'src/app/services/film-repository.service';
import { Film } from 'src/app/metier/Film';
import { VirtualTimeScheduler, Subscription } from 'rxjs';
import { Page } from 'src/app/metier/page';

@Component({
  selector: 'app-film-liste',
  templateUrl: './film-liste.component.html',
  styleUrls: ['./film-liste.component.css']
})

//onDestroy permet de detruire
export class FilmListeComponent implements OnInit,OnDestroy {



  //-----------------------PREPARATION DES COMPOSANT DE PAGINATION-------------------------
  public totalItems : number;
  public currentPage:number;
  public taillePage:number;


  //-----------------------DECLARATION D UN TABLEAU VIDE-------------------------
  films: Page<Film>;




  //la souscription au films de Filmrepository
  //nous permetttra de nous 'déenregistrer comme observateur des films
  //quand le composant listeFIlm sera détruit
  filmSouscription : Subscription;

  //quand vous ajoutez un argument au constructeur d'un component
  //angular considere que c'est une dependance à vous injecter
   //-----------------------DECLARER LE CONSTRUCTION POUR INJECTER LES DONNEES-------------------------
  constructor(private filmRepository:FilmRepositoryService){

     //-----------------------PAGINATION-------------------------
    this.totalItems=30;
    this.currentPage=1;
    this.taillePage=5;
  }


  title = 'Jennifer';





   //-----------------------AFFICHER TT LES ELEMENTS-------------------------
  ngOnInit(): void {
    //appelle de la function emptyPage
    this.films = Page.emptyPage<Film>();

    //souscrire les arguments
    this.filmSouscription = this.filmRepository
                                .getPageFilmAsObservable()
                                .subscribe(p => {
                                    this.films = p;
                                    this.totalItems = p.totalElements;
                                    this.taillePage = p.size;
                                    this.currentPage = p.number + 1;
                                });/*souscrit en permanence*/

                                
        //demander d'envoyer la requete au serveur
        this.filmRepository.refreshListe();


  }


  //----------------------------Cela permet de se desinscrire------------------------------
  ngOnDestroy(): void {
    this.filmSouscription.unsubscribe();
  }




  //-----------------------SUPPRIMER UN ELEMENT PAR L ID DU COTE FRONT-------------------------
  public effacerFilm(id : number):void{
      console.log("Effacement du film no " + id + " demandé");
      this.filmRepository.deleteFilm(id).then(data => this.filmRepository.refreshListe());//refreshListe déclarer dans film repository
  }



  //---------------------------EVENEMENT SUR LE CLICK DU BOUTON-----------------------
  public pageChanged(event : any )  {
    console.log(event);
    this.filmRepository.setNoPage(event.page - 1);
  }

}
