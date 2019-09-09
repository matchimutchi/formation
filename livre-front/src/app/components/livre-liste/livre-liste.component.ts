import { Component, OnInit, OnDestroy } from '@angular/core';
import { Livre } from 'src/app/metier/Livre';
import { LivreRepositoryService } from 'src/app/services/livre-repository.service';
import { Page } from 'src/app/metier/page';
import { Subscription, Subject } from 'rxjs';
import {debounceTime} from "rxjs/operators";
import { User } from 'src/app/metier/user';
import { AuthManagerService } from 'src/app/services/auth-manager.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-livre-liste',
  templateUrl: './livre-liste.component.html',
  styleUrls: ['./livre-liste.component.css']
})
export class LivreListeComponent implements OnInit,OnDestroy {


  currentUser : [boolean,User];

  //-----------------------PREPARATION DES COMPOSANT DE PAGINATION-------------------------
  public totalItems : number;
  public currentPage:number;
  public taillePage:number;
  private searchSubject : Subject<string>;

    //-----------------------DECLARATION D UN TABLEAU VIDE-------------------------
    //livres: Promise<Livre[]>;
   public livres: Page<Livre>;



    public livreSouscription : Subscription;
    recherche : string;

  constructor(private livreRepository:LivreRepositoryService,private authManager : AuthManagerService,private router : Router) {
    this.totalItems=30;
    this.currentPage=1;
    this.taillePage=5;
    this.currentUser = [false,null];

   }

   public logout() : void{
    this.authManager.logout();
    this.router.navigateByUrl("/login");
  }


  ngOnInit() :void {
    this.authManager.getUserSubjectAsObservable()
    .subscribe( u => {
      this.currentUser = u;
    });

    
    this.livres = Page.emptyPage<Livre>();

    this.livreSouscription = this.livreRepository
                                .getPageLivreAsObservable()
                                .subscribe(p => {
                                    this.livres = p;
                                    this.totalItems = p.totalElements;
                                    this.taillePage = p.size;
                                    this.currentPage = p.number + 1;
                                });

        this.livreRepository.refreshListe();
        this.recherche ="";
        this.searchSubject = new Subject();
        this.searchSubject.asObservable().pipe(debounceTime(500)).subscribe(term => this.livreRepository.setSearchTerm(term));
        //this.livres = this.livreRepository.getListeLivres();
  }


  ngOnDestroy(): void {
    this.livreSouscription.unsubscribe();
  }



  //-----------------------SUPPRIMER UN ELEMENT PAR L ID DU COTE FRONT-------------------------
    public effacerLivre(id : number):void{
      console.log("Effacement du livre no " + id + " demandé");
      this.livreRepository.deleteLivre(id).then(data => this.livreRepository.refreshListe());
  }





    //---------------------------EVENEMENT SUR LE CLICK DU BOUTON-----------------------
    public pageChanged(event : any )  {
      console.log(event);
      this.livreRepository.setNoPage(event.page - 1);
    }
  


    //public recherche : string;

    public searchTitre(event){
      
      this.recherche = event;
      //console.log(event);
      this.searchSubject.next(event);
      //this.livreRepository.searchLivre(this.recherche).then( s => this.livreRepository.refreshListe());

    }


  

}
