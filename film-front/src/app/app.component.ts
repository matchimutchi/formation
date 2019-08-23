import { Component, OnInit } from '@angular/core';
import { Film } from './metier/Film';
import { FilmRepositoryService } from './services/film-repository.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  //quand vous ajoutez un argument au constructeur d'un component
  //angular considere que c'est une dependance à vous injecter
  constructor(private filmRepository:FilmRepositoryService){

  }
  title = 'Jennifer';

  films: Film[] =[];

  ngOnInit(): void {
    this.films = this.filmRepository.getListeFilms();
  }

}
