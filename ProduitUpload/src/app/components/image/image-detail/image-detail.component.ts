import { Component, OnInit } from '@angular/core';
import { Image } from 'src/app/metier/image';
import { ActivatedRoute, Router } from '@angular/router';
import { ImageRepositoryService } from 'src/app/services/image-repository.service';
import { ProduitRepositoryService } from 'src/app/services/produit-repository.service';
import { Produit } from 'src/app/metier/produit';

@Component({
  selector: 'app-image-detail',
  templateUrl: './image-detail.component.html',
  styleUrls: ['./image-detail.component.css']
})
export class ImageDetailComponent implements OnInit {

  //l'image en cours d'edition
  editImage : Image;

  public produits : Produit[];

  constructor(private activeRoute : ActivatedRoute,
              private router : Router,
              private imageRepository : ImageRepositoryService, private produitRepository : ProduitRepositoryService) { }

  ngOnInit() {
    this.editImage = null;

    this.activeRoute.params.subscribe(params =>{
      let id: number = Number(params['id']);
      this.imageRepository.findById(id).then(i => {
        this.editImage = i;
      })
    })

    this.produitRepository.getListeProduits().then( p => this.produits = p.content);
  }


  public getImageUrl(id: number) : string {
    return this.imageRepository.getImageUrl(id);
  }


  
  public saveImage() : void{
    this.imageRepository.updateImage(this.editImage.id,this.editImage.nom);
    this.router.navigateByUrl("/images");
  }

}
