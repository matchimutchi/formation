import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Page } from '../metier/page';
import { AuteurListeComponent } from '../components/auteur-liste/auteur-liste.component';
import { Auteur } from '../metier/Auteur';
import { HttpParams, HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuteurRepositoryService {

   
  //-----------------------CONNEXION AU BACK-------------------------
  private serviceUrl: string = "http://localhost:8080/auteurs";


    //------------------DECLARATION  POUR LA PAGINATION------------
    private auteursSubject : BehaviorSubject<Page<Auteur>>;

    //information pagination
    private noPage : number;
    private taillePage : number;
  

  //------------pour pouvoir ecrire dans le noPage---------------------
  public setNoPage(noPage:number) : void{
    this.noPage = noPage;
    this.refreshListe();
  }


  public refreshListe() : void{

    let urlParams : HttpParams = new HttpParams();
    urlParams = urlParams.set("page","" + this.noPage).set("size","" + this.taillePage);
    this.http.get<Page<Auteur>>(this.serviceUrl,{params : urlParams}).toPromise().then(p => this.auteursSubject.next(p));
  }

  
  //-----------------------DECLARATION D UN TABLEAU VIDE-------------------------
  private auteurs : Auteur[];




  //-----------------------DECLARER LE CONSTRUCTION http-------------------------
  constructor(private http: HttpClient) {
      
      this.auteursSubject = new BehaviorSubject(Page.emptyPage<Auteur>());
      this.noPage = 0;
      this.taillePage = 5;

   }


   public getPageAuteurAsObservable() : Observable<Page<Auteur>>{
    return this.auteursSubject.asObservable();
  }

   //-----------------------AFFICHER TT LES ELEMENTS-------------------------
   public getListeAuteurs() : Promise<Page<Auteur>>{
    return this.http.get<Page<Auteur>>(this.serviceUrl).toPromise();
   }



   //-----------------------RECHERCHER UN SEUL ELEMENT PAR L ID-------------------------
   public getAuteurById(id : number): Promise<Auteur>{

      return this.http.get<Auteur>(`${this.serviceUrl}/${id}`).toPromise();
   }




   //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
   public saveAuteur(auteur : Auteur) : Promise<Auteur>{
      if(auteur.id != 0){
          return this.http.put<Auteur>(this.serviceUrl,auteur).toPromise();
      }else{
        return this.http.post<Auteur>(this.serviceUrl,auteur).toPromise();
      }
   }




   //-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
   public deleteAuteur(id : number) : Promise<any>{
    return this.http.delete<any>(`${this.serviceUrl}/${id}`).toPromise();
 }
}
