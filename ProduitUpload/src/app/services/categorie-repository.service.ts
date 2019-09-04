import { Injectable } from '@angular/core';
import { Categorie } from '../metier/categorie';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Page } from '../metier/page';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategorieRepositoryService {

  
  private serviceUrl : string = 'http://localhost:8080/categories';
  // ---------------------------------pagination------------------------------
  private noPage: number;
  private taillePage: number;
  private categorieSubject : BehaviorSubject<Page<Categorie>>;

  //-----------------------injection du requetteur---------------------------------
  constructor(private http : HttpClient) {
    this.noPage = 0;
    this.taillePage = 12;
    this.categorieSubject = new BehaviorSubject(Page.emptyPage<Categorie>());

  }

  public getCategorieAsObservable() : Observable<Page<Categorie>> {
    return this.categorieSubject.asObservable();
  }


  public getListeCategorie() : Promise<Page<Categorie>>{
    return this.http.get<Page<Categorie>>(this.serviceUrl).toPromise();
   }


  //---------------------------REFRECH---------------------------------------
  public refreshListe() :void  {
    let urlParams : HttpParams = new HttpParams().set('page', "" + this.noPage)
                                                 .set('size', "" + this.taillePage);

    this.http.get<Page<Categorie>>(this.serviceUrl, {params: urlParams})
             .subscribe(i => this.categorieSubject.next(i));
  }


  //---------------------------------Nopages----------------------------------
  public setNopage(noPage : number) : void {
    this.noPage = noPage;
    this.refreshListe();
  }




  // -------------------url pour l'upload--------------------------
  public getUploadUrl() : string {
    return `${this.serviceUrl}/upload`;
  }

  //   //-----------------FINDBYID------------------
    public findById(id : number) : Promise<Categorie>{
      return this.http.get<Categorie>(`${this.serviceUrl}/${id}`).toPromise();
    }


  // //-----------------------DELETE----------------------------------
  public deleteImage(id:number) : void{
    this.http.delete<any>(`${this.serviceUrl}/${id}`).subscribe(r => this.refreshListe());
  }
}
