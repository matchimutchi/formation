import { Component, OnInit } from '@angular/core';
import { faShoppingBasket, faUser} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  faShoppingBasket = faShoppingBasket;
  faUser = faUser;
  constructor() {

   }

  ngOnInit() {
  }

}
