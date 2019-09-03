import { Component, OnInit } from '@angular/core';
import { ProduitRepositoryService } from 'src/app/services/produit-repository.service';
import { Page } from 'src/app/metier/page';
import { Produit } from 'src/app/metier/produit';
import { Subscription, Observable } from 'rxjs';

@Component({
  selector: 'app-produit-liste',
  templateUrl: './produit-liste.component.html',
  styleUrls: ['./produit-liste.component.css']
})
export class ProduitListeComponent implements OnInit {

  produits : Page<Produit>

    // pagination
    noPage : number;
    taillePage: number;
    totalItems: number;


  constructor(private produitRepository : ProduitRepositoryService) {

   }



  private produitSubscription : Subscription;

  ngOnInit() {
    this.noPage = 1;
    this.taillePage = 6;
    this.totalItems = 0;
    this.produits = Page.emptyPage<Produit>();


    this.produitSubscription = this.produitRepository.getProduitsAsObservable()
                                   .subscribe(p => {
                                      this.noPage = p.number + 1;
                                      this.taillePage = p.size;
                                      this.totalItems = p.totalElements;
                                      this.produits = p;
                                   });
    // requetage initial des images
    this.produitRepository.refreshListe();
  }


  
  public pageChanged(event) : void {
    this.produitRepository.setNopage(event.page - 1);
  }

}
