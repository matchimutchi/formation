import { Injectable } from '@angular/core';
import { Film } from '../metier/Film';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Page } from '../metier/page';

@Injectable({
  providedIn: 'root'
})
export class FilmRepositoryService {



  //-----------------------CONNEXION AU BACK-------------------------
  private serviceUrl: string = "http://localhost:8080/films";




  //------------------DECLARATION  POUR LA PAGINATION------------
  private filmsSubject : BehaviorSubject<Page<Film>>;

  //information pagination
  private noPage : number;
  private taillePage : number;


  //------------pour pouvoir ecrire dans le noPage---------------------
  public setNoPage(noPage:number) : void{
    this.noPage = noPage;
    //rafraichir la liste du tableau
    this.refreshListe();
  }



  //------------------------RAFRAICHIR LA PAGE-------------------------
  //Quand je demande un rafraichissement de la liste, j'envoi une requete get, puis je republi la page recu
  //dans le sujet des film pour ceux qui ecoute
  public refreshListe() : void{



    //--------------cela permet d'avoir des argument dans mon url exemple ? ou = -------------------
    let urlParams : HttpParams = new HttpParams();
    urlParams = urlParams.set("page","" + this.noPage).set("size","" + this.taillePage);

    //----------------params est une propriété de typescript----------------
    this.http.get<Page<Film>>(this.serviceUrl,{params : urlParams}).toPromise().then(p => this.filmsSubject.next(p));
  }



  //-----------------------DECLARATION D UN TABLEAU VIDE-------------------------
  private films : Film[];




  //-----------------------DECLARER LE CONSTRUCTION http-------------------------
  constructor(private http: HttpClient) {
    //initialiser une page vide
    this.filmsSubject = new BehaviorSubject(Page.emptyPage<Film>());

    //initialiser les arguments de la pagination
    this.noPage = 0;
    this.taillePage = 5;

   }


   //recuperer un observable
   //cette fonction permet d'observer les sujet des pages de films
   public getPageFilmAsObservable() : Observable<Page<Film>>{
     return this.filmsSubject.asObservable();
   }


   //-----------------------AFFICHER TT LES ELEMENTS-------------------------
   public getListeFilms() : Promise<Film[]>{
    return this.http.get<Film[]>(this.serviceUrl).toPromise();
   }



   //-----------------------RECHERCHER UN SEUL ELEMENT PAR L ID-------------------------
   public getFilmById(id : number): Promise<Film>{
     //le `` en typescript définit une chaine multiligne dans laquelle
     //on peut injecter des variables directement avec ${variable}
    // on appele ca l'interpolation de chaine
      return this.http.get<Film>(`${this.serviceUrl}/${id}`).toPromise();
   }




   //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
   public saveFilm(film : Film) : Promise<Film>{
      if(film.id != 0){
          return this.http.put<Film>(this.serviceUrl,film).toPromise();
      }else{
        return this.http.post<Film>(this.serviceUrl,film).toPromise();
      }
   }




   //-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
   public deleteFilm(id : number) : Promise<any>{
    return this.http.delete<any>(`${this.serviceUrl}/${id}`).toPromise();
 }

   
}
