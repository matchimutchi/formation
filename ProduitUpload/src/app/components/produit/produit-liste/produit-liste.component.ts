import { Component, OnInit, TemplateRef } from '@angular/core';
import { ProduitRepositoryService } from 'src/app/services/produit-repository.service';
import { Page } from 'src/app/metier/page';
import { Produit } from 'src/app/metier/produit';
import { Subscription } from 'rxjs';
import { ImageRepositoryService } from 'src/app/services/image-repository.service';
import {faEdit,faDownload,faTrash, faShoppingBasket} from '@fortawesome/free-solid-svg-icons';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';



@Component({
  selector: 'app-produit-liste',
  templateUrl: './produit-liste.component.html',
  styleUrls: ['./produit-liste.component.css']
})
export class ProduitListeComponent implements OnInit {
//icon
faTrash=faTrash;
faDownload = faDownload;
faEdit = faEdit;
faShoppingBasket = faShoppingBasket;
produits : Page<Produit>;
// pagination
noPage : number;
taillePage: number;
totalItems: number;
private produitSubscription: Subscription;

//-----------MODAL---------------
modalRef: BsModalRef;
toDelete : Produit; //image a supprimer si popup confirmé

constructor(private produitRepository : ProduitRepositoryService,private imageRepository : ImageRepositoryService,private modalService: BsModalService) { 
}



ngOnInit() {
  this.toDelete = null;
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

public getImageUrl(p:Produit) : string {
  if(p.images.length > 0){
    return this.imageRepository.getImageUrl(p.images[0].id);
  }
 return "";
}


public getThumbnailUrl(p:Produit) : string {
  if(p.images.length > 0){
    return this.imageRepository.getThumbnailUrl(p.images[0].id);
  }
  return "";
}


//------------------Modal---------
public openDeleteModal(template: TemplateRef<any>,p : Produit) {
   //selection d'image a effacer
  this.toDelete = p;
  //affichage du modal
  this.modalRef = this.modalService.show(template, {class: 'modal-sm'});
}

confirmDelete(): void {
  console.log("Effacement de " + this.toDelete.id);
  this.modalRef.hide();
  this.produitRepository.deleteProduit(this.toDelete.id);
  this.toDelete = null;
}

declineDelete(): void {
  console.log("Annulation de l'effacement de " + this.toDelete.id);
  this.modalRef.hide();
  this.toDelete = null;
}
  
  // produits : Page<Produit>

  //   // pagination
  //   noPage : number;
  //   taillePage: number;
  //   totalItems: number;


  // constructor(private produitRepository : ProduitRepositoryService) {

  //  }



  // private produitSubscription : Subscription;

  // ngOnInit() {
  //   this.noPage = 1;
  //   this.taillePage = 6;
  //   this.totalItems = 0;
  //   this.produits = Page.emptyPage<Produit>();


  //   this.produitSubscription = this.produitRepository.getProduitsAsObservable()
  //                                  .subscribe(p => {
  //                                     this.noPage = p.number + 1;
  //                                     this.taillePage = p.size;
  //                                     this.totalItems = p.totalElements;
  //                                     this.produits = p;
  //                                  });
  //   // requetage initial des images
  //   this.produitRepository.refreshListe();
  // }


  
  // public pageChanged(event) : void {
  //   this.produitRepository.setNopage(event.page - 1);
  // }

}
