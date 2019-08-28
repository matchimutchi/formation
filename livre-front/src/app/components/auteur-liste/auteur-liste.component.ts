import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Page } from 'src/app/metier/page';
import { AuteurRepositoryService } from 'src/app/services/auteur-repository.service';
import { Auteur } from 'src/app/metier/Auteur';

@Component({
  selector: 'app-auteur-liste',
  templateUrl: './auteur-liste.component.html',
  styleUrls: ['./auteur-liste.component.css']
})
export class AuteurListeComponent implements OnInit,OnDestroy {


  
  //-----------------------PREPARATION DES COMPOSANT DE PAGINATION-------------------------
  public totalItems : number;
  public currentPage:number;
  public taillePage:number;


    //-----------------------DECLARATION D UN TABLEAU VIDE-------------------------
    auteurs: Page<Auteur>;



   auteurSouscription : Subscription;


  constructor(private auteurRepository:AuteurRepositoryService) {
    this.totalItems=30;
    this.currentPage=1;
    this.taillePage=5;

   }



  ngOnInit() :void {

    this.auteurs = Page.emptyPage<Auteur>();

    this.auteurSouscription = this.auteurRepository
                                .getPageAuteurAsObservable()
                                .subscribe(p => {
                                    this.auteurs = p;
                                    this.totalItems = p.totalElements;
                                    this.taillePage = p.size;
                                    this.currentPage = p.number + 1;
                                });

        this.auteurRepository.refreshListe();

  }


  ngOnDestroy(): void {
    this.auteurSouscription.unsubscribe();
  }



  //-----------------------SUPPRIMER UN ELEMENT PAR L ID DU COTE FRONT-------------------------
    public effacerAUteur(id : number):void{
      console.log("Effacement du auteur no " + id + " demandé");
      this.auteurRepository.deleteAuteur(id).then(data => this.auteurRepository.refreshListe());
  }




  //---------------------------EVENEMENT SUR LE CLICK DU BOUTON-----------------------
    public pageChanged(event : any )  {
      console.log(event);
      this.auteurRepository.setNoPage(event.page - 1);
    }
}
