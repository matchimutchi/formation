import { Injectable } from '@angular/core';
import { HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Page } from '../metier/page';
import { Produit } from '../metier/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitRepositoryService {

  private serviceUrl : string = 'http://localhost:8080/produit';


  
  // ---------------------------------pagination------------------------------
  private noPage: number;
  private taillePage: number;

  private picturesSubject : BehaviorSubject<Page<Produit>>;



  //-----------------------injection du requetteur---------------------------------
  constructor(private http : HttpClient) {
    this.noPage = 0;
    this.taillePage = 12;
    this.picturesSubject = new BehaviorSubject(Page.emptyPage<Produit>());

  }

  public getProduitsAsObservable() : Observable<Page<Produit>> {
    return this.picturesSubject.asObservable();
  }



  //---------------------------REFRECH---------------------------------------
  public refreshListe() :void  {
    let urlParams : HttpParams = new HttpParams().set('page', "" + this.noPage)
                                                 .set('size', "" + this.taillePage);
    // j'envoie la requete ajax
    // quand j'ai la reponse, je republie dans picturesSubject
    this.http.get<Page<Produit>>(this.serviceUrl, {params: urlParams})
             .subscribe(p => this.picturesSubject.next(p));
  }


  //---------------------------------Nopages----------------------------------
  public setNopage(noPage : number) : void {
    this.noPage = noPage;
    this.refreshListe();
  }




  // -----------------------genere l'url correcte pour afficher une image--------------------
  public getImageUrl(id : number) : string {
    return `${this.serviceUrl}/${id}/data`;
  }




    //----------------------- genere l'url correcte pour afficher une image miniature--------------------------
    public getThumbnailUrl(id : number) : string {
      return `${this.serviceUrl}/${id}/thumbdata`;
    }


   //-----------------------RECHERCHER UN SEUL ELEMENT PAR L ID-------------------------
   public getProduitById(id : number): Promise<Produit>{
    //le `` en typescript définit une chaine multiligne dans laquelle
    //on peut injecter des variables directement avec ${variable}
   // on appele ca l'interpolation de chaine
     return this.http.get<Produit>(`${this.serviceUrl}/${id}`).toPromise();
  }




  //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
  public saveProduit(produit : Produit) : Promise<Produit>{
    let urlParams : HttpParams = new HttpParams();
    urlParams = urlParams.set("categorieId", "" + produit.categorie.id);
     if(produit.id != 0){
         return this.http.put<Produit>(this.serviceUrl,produit,{params: urlParams}).toPromise();
     }else{
       return this.http.post<Produit>(this.serviceUrl,produit,{params: urlParams}).toPromise();
     }
  }



  // -------------------url pour l'upload--------------------------
  public getUploadUrl() : string {
    return `${this.serviceUrl}/edit`;
  }

    //-----------------FINDBYID------------------
    public findById(id : number) : Promise<Produit>{
      return this.http.get<Produit>(`${this.serviceUrl}/${id}`).toPromise();
    }

    public updateProduit(id: number, nom:string):void{
      let urlParams : HttpParams = new HttpParams().set('nom',nom);
      //put angular me force a mettre un objet dans le corp de la requette
      //comme je n'en ai pas ici (juste un titre) je passe un objet vide
      this.http.put(`${this.serviceUrl}/${id}`,{},{params : urlParams})
              .subscribe( r => this.refreshListe());
    }

  //-----------------------DELETE----------------------------------
  public deleteProduit(id:number) : void{
    this.http.delete<any>(`${this.serviceUrl}/${id}`).subscribe(r => this.refreshListe());
  }

  public getListeProduits() : Promise<Page<Produit>>{
    return this.http.get<Page<Produit>>(this.serviceUrl).toPromise();
   }


 
}
