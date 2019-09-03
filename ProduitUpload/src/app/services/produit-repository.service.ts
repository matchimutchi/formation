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

  private produitsSubject : BehaviorSubject<Page<Produit>>;
  
  constructor(private http : HttpClient) { 
    this.noPage = 0;
    this.taillePage = 8;
    this.produitsSubject = new BehaviorSubject(Page.emptyPage<Produit>());
  }

    //---------------------------REFRECH---------------------------------------
    public refreshListe() :void  {
      let urlParams : HttpParams = new HttpParams().set('page', "" + this.noPage)
                                                   .set('size', "" + this.taillePage);

      this.http.get<Page<Produit>>(this.serviceUrl, {params: urlParams})
               .subscribe(p => this.produitsSubject.next(p));
    }



    public getProduitsAsObservable() : Observable<Page<Produit>> {
      return this.produitsSubject.asObservable();
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

  //-----------------FINDBYID------------------
  public findById(id : number) : Promise<Produit>{
    return this.http.get<Produit>(`${this.serviceUrl}/${id}`).toPromise();
  }

  //-----------------------DELETE----------------------------------
    public deleteProduit(id:number) : void{
    this.http.delete<any>(`${this.serviceUrl}/${id}`).subscribe(r => this.refreshListe());
  }

    
}
