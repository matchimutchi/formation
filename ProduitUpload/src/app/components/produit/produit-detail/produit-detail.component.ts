import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/metier/produit';
import { ProduitRepositoryService } from 'src/app/services/produit-repository.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FileUploader } from 'ng2-file-upload';
import { ImageRepositoryService } from 'src/app/services/image-repository.service';
import { Image } from 'src/app/metier/image';
import { Categorie } from 'src/app/metier/categorie';
import { CategorieRepositoryService } from 'src/app/services/categorie-repository.service';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css']
})

export class ProduitDetailComponent implements OnInit {
  public uploader: FileUploader = null;
  public hasBaseDropZoneOver : boolean = false;



    //-----------------------DECLARATION D UN OBJET-------------------------
    public editProduit : Produit;
    public images : Image;
    public categories : Categorie[];

    //declaration des Class dans le constructeur constructeurs 
    constructor(private produitRepository : ProduitRepositoryService,private categorieRepository : CategorieRepositoryService,private activeRoute : ActivatedRoute,private router : Router,private imageRepository:ImageRepositoryService) {
  



     }
  
  

     

    //-----------------------INITIALISER LE FORMULAIRE-------------------------
    ngOnInit() {
      this.editProduit = new Produit(0,"",0.0,0.0);
      this.editProduit.categorie = new Categorie(0,"");
      this.activeRoute.params.subscribe( params => {
        let id = Number(params['id']);
        console.log("recu id produit -> " + id);
  
        if(id != 0){
          //-----------------------AFFICHER TT LES ELEMENTS-------------------------
          //then = QUAND LA PROMESE EST RESOLU on affiche le resultat
          this.produitRepository.getProduitById(id).then( p => {
            this.editProduit = p;
            this.uploader = new FileUploader({
              autoUpload : true,
              url: this.imageRepository.getUploadUrl(),
              additionalParameter: {produitId:p.id}
            });
      
            this.uploader.onBeforeUploadItem = item => {
              item.withCredentials = false;
            };
          });
        }
      });

      this.categorieRepository.getListeCategorie().then( p => {
        console.log(p.content);
        this.categories = p.content;
      });


    }
  
  
  
  
   //-----------------------MODIFIER OU INSERER UN ELEMENT PAR L ID-------------------------
    public sauverProduit() : void{
      // console.log("sauvegarde de ");
      // console.log(this.editProduit);
  
      this.produitRepository.saveProduit(this.editProduit).then(p =>{
        
        // console.log("Sauvegarde OK");
        // console.log(p);
  
        //-----------------------REDIRECTION VERS LISTE-------------------------
        this.router.navigateByUrl('/produit');
      });
    }


    public fileOverDrop(event) {
      //console.log("file over");
      //console.log(event);
      this.hasBaseDropZoneOver = event;
    }

}
