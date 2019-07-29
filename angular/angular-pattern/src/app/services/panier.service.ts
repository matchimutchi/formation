import { Injectable } from '@angular/core';
import { Produit } from '../metier/Produit';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  //on déclare un panier vide
  private produits : Produit[];
  //le sujet a observer, c'est à travers lui que je préviendrais les observable
  private produitsSubject : BehaviorSubject<Produit[]>;

  constructor() { 
    //on déclare un tableau vide
    this.produits = [];
    //on initialise notre sujet pour cmmencer avec un panier vide(tableau vide)
    this.produitsSubject = new BehaviorSubject(this.produits);


  }

  //s'abonner a l'observable une liste de produit
  public getProduitAsObservable() : Observable<Produit[]>{
    //un observable permet à un observateur de s'abonner
    //pour être prévenu des modifications
    //l'avantage de l'observable, c'est qu'il nous permet que
    // de s'abonner, et aucune autre opération
    return this.produitsSubject.asObservable();
  }

  //ajouter des produit
  public ajouterProduit(produit : Produit) : void{
    //ajouter le nouveau produit au panier
    this.produits.push(produit);
    //je previens ceux qui sont abonné à mon produitSubject
    this.produitsSubject.next(this.produits);

  }


  public viderPanier():void{
    //on initialise notre produit
    this.produits = [];
    // next = publier
    this.produitsSubject.next(this.produits);
  }

}
