import { Component, OnInit, TemplateRef } from '@angular/core';
import { Image } from 'src/app/metier/image';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Subscription } from 'rxjs';
import { Page } from 'src/app/metier/page';
import { ImageRepositoryService } from 'src/app/services/image-repository.service';
import {faEdit,faDownload,faTrash} from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'app-image-liste',
  templateUrl: './image-liste.component.html',
  styleUrls: ['./image-liste.component.css']
})
export class ImageListeComponent implements OnInit {


  images : Page<Image>;

  faTrash=faTrash;
  faDownload = faDownload;
  faEdit = faEdit;


   // pagination
   noPage : number;
   taillePage: number;
   totalItems: number;
   private imageSubscription: Subscription;
 
   //-----------MODAL---------------
   modalRef: BsModalRef; //reference du popup une fois ouvert
   toDelete : Image; //image a supprimer si popup confirmé
 
   constructor(private imageRepository : ImageRepositoryService, private modalService: BsModalService ) { 
   }
 
 
 
   ngOnInit() {
     this.toDelete = null;
     this.noPage = 1;
     this.taillePage = 6;
     this.totalItems = 0;
     this.images = Page.emptyPage<Image>();
     this.imageSubscription = this.imageRepository.getImagesAsObservable()
                                    .subscribe(i => {
                                       this.noPage = i.number + 1;
                                       this.taillePage = i.size;
                                       this.totalItems = i.totalElements;
                                       this.images = i;
                                    });
     // requetage initial des images
     this.imageRepository.refreshListe();
   }
 
   public pageChanged(event) : void {
     this.imageRepository.setNopage(event.page - 1);
   }
 
   public getImageUrl(id: number) : string {
     return this.imageRepository.getImageUrl(id);
   }
 
   
   public getThumbnailUrl(id: number) : string {
     return this.imageRepository.getThumbnailUrl(id);
   }
 
 
   //------------------Modal---------
   public openDeleteModal(template: TemplateRef<any>,i : Image) {
      //selection d'image a effacer
     this.toDelete = i;
     //affichage du modal
     this.modalRef = this.modalService.show(template, {class: 'modal-sm'});
   }
 
   confirmDelete(): void {
     console.log("Effacement de " + this.toDelete.nom);
     this.modalRef.hide();
     this.imageRepository.deleteImage(this.toDelete.id);
     this.toDelete = null;
   }
 
   declineDelete(): void {
     console.log("Annulation de l'effacement de " + this.toDelete.nom);
     this.modalRef.hide();
     this.toDelete = null;
   }

}
