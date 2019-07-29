import { Component, OnInit } from '@angular/core';
import { PanierService } from 'src/app/services/panier.service';

@Component({
  selector: 'app-panier-cout',
  templateUrl: './panier-cout.component.html',
  styleUrls: ['./panier-cout.component.css']
})
export class PanierCoutComponent implements OnInit {

  public coutPanier : number;

  constructor(private panierService : PanierService) { }

  ngOnInit() {
    this.coutPanier = 0;
    this.panierService.getProduitAsObservable().subscribe((data) => 
                                                {this.coutPanier = 0; 
                                                  for(let p of data){
                                                    this.coutPanier += 1;
                                                  }
                                                });
  }

}
