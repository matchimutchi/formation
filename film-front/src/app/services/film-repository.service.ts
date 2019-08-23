import { Injectable } from '@angular/core';
import { Film } from '../metier/Film';

@Injectable({
  providedIn: 'root'
})
export class FilmRepositoryService {

  private films : Film[];
  constructor() {
    this.films = [
      new Film(1, "l'attaque des courgettes tueuses",115,new Date()),
      new Film(2, "les titans a la plage",135,new Date()),
      new Film(3, "Batman contre les courgettes tueuses",145,new Date())
    ];
   }

   public getListeFilms() : Film[]{
     return this.films;
   }
}
