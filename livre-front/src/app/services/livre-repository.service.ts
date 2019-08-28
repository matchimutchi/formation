import { Injectable } from '@angular/core';
import { Livre } from '../metier/Livre';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Page } from '../metier/page';
import { Auteur } from '../metier/Auteur';
import { promise } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class LivreRepositoryService {


  
  //-----------------------CONNEXION AU BACK-------------------------
  private serviceUrl: string;


    //------------------DECLARATION  POUR LA PAGINATION------------
    private livresSubject : BehaviorSubject<Page<Livre>>;

    //information pagination
    private noPage : number;
    private taillePage : number;


    //-------------------RECHERCHE-------------------------------
    private searchTerm : string;



  //-----------------------DECLARER LE CONSTRUCTION http-------------------------
  constructor(private http: HttpClient) {
      
    this.livresSubject = new BehaviorSubject(Page.emptyPage<Livre>());
    this.noPage = 0;
    this.taillePage = 5;
    this.serviceUrl = "http://localhost:8080/livres";

 }

     
  //-----------------------DECLARATION D UN TABLEAU VIDE-------------------------
  private livres : Livre[];


  //-------------------------RAFRAICHIR LA PAGE----------------------------------

  public refreshListe() : void{

    let urlParams : HttpParams = new HttpParams();
    urlParams = urlParams.set("page","" + this.noPage).set("size","" + this.taillePage);

    //si searchTerm non vide lajouter a la requete
    if(this.searchTerm != null && this.searchTerm.length > 0){  
      urlParams = urlParams.set('searchTerm',this.searchTerm);
    }
    this.http.get<Page<Livre>>(this.serviceUrl,{params : urlParams}).toPromise().then(p => this.livresSubject.next(p));
  }

  
    //------------pour pouvoir ecrire dans le noPage---------------------
    public setNoPage(noPage:number) : void{
      this.noPage = noPage;
      //rafraichir la liste du tableau
      this.refreshListe();
    }


    public setSearchTerm(searchTerm:string) : void{
      this.searchTerm = searchTerm;
      this.refreshListe();
    }


   public getPageLivreAsObservable() : Observable<Page<Livre>>{
    return this.livresSubject.asObservable();
  }



   //-----------------------AFFICHER TT LES ELEMENTS-------------------------
   public getListeLivres() : Promise<Livre[]>{
    return this.http.get<Livre[]>(this.serviceUrl).toPromise();
   }


   //-----------------------RECHERCHER UN SEUL ELEMENT PAR L ID-------------------------
   public getLivreById(id : number): Promise<Livre>{

      return this.http.get<Livre>(`${this.serviceUrl}/${id}`).toPromise();
   }


   //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
   public saveLivre(livre : Livre) : Promise<Livre>{
    let urlParams : HttpParams = new HttpParams();
    urlParams = urlParams.set("auteurId", livre.auteur.id);
      if(livre.id != 0){
          return this.http.put<Livre>(this.serviceUrl,livre,{params: urlParams}).toPromise();
      }else{
        return this.http.post<Livre>(this.serviceUrl,livre,{params: urlParams}).toPromise();
      }
   }





   //-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
   public deleteLivre(id : number) : Promise<any>{
    return this.http.delete<any>(`${this.serviceUrl}/${id}`).toPromise();
 }



 //public searchLivre(titre : string) : Promise<Page<Livre>>{  
   //return this.http.get<Page<Livre>>(`${this.serviceUrl}/titre/${titre}`).toPromise();
 //}

}
