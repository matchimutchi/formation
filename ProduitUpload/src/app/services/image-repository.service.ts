import { Injectable } from '@angular/core';
import { Image } from '../metier/image';
import { HttpParams, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Page } from '../metier/page';


@Injectable({
  providedIn: 'root'
})
export class ImageRepositoryService {

  private serviceUrl : string = 'http://localhost:8080/images';
  // ---------------------------------pagination------------------------------
  private noPage: number;
  private taillePage: number;

  private imagesSubject : BehaviorSubject<Page<Image>>;

  //-----------------------injection du requetteur---------------------------------
  constructor(private http : HttpClient) {
    this.noPage = 0;
    this.taillePage = 12;
    this.imagesSubject = new BehaviorSubject(Page.emptyPage<Image>());

  }

  public getImagesAsObservable() : Observable<Page<Image>> {
    return this.imagesSubject.asObservable();
  }


  public getListeImages() : Promise<Page<Image>>{
    return this.http.get<Page<Image>>(this.serviceUrl).toPromise();
   }


  //---------------------------REFRECH---------------------------------------
  public refreshListe() :void  {
    let urlParams : HttpParams = new HttpParams().set('page', "" + this.noPage)
                                                 .set('size', "" + this.taillePage);

    this.http.get<Page<Image>>(this.serviceUrl, {params: urlParams})
             .subscribe(i => this.imagesSubject.next(i));
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




  // -------------------url pour l'upload--------------------------
  public getUploadUrl() : string {
    return `${this.serviceUrl}/upload`;
  }

  //   //-----------------FINDBYID------------------
    public findById(id : number) : Promise<Image>{
      return this.http.get<Image>(`${this.serviceUrl}/${id}`).toPromise();
    }

    public updateImage(id: number, nom:string):void{
      let urlParams : HttpParams = new HttpParams().set('nom',nom);
      //put angular me force a mettre un objet dans le corp de la requette
      //comme je n'en ai pas ici (juste un titre) je passe un objet vide
      this.http.put(`${this.serviceUrl}/${id}`,{},{params : urlParams})
              .subscribe( r => this.refreshListe());
    }

  // //-----------------------DELETE----------------------------------
  public deleteImage(id:number) : void{
    this.http.delete<any>(`${this.serviceUrl}/${id}`).subscribe(r => this.refreshListe());
  }

}
