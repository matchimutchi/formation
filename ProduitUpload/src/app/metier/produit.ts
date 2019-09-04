import { Image } from './image';
import { Categorie } from './categorie';

export class Produit{
    constructor(public id: number,
                public nom :string,
                public prix :number,
                public poids : number,
                public images?:Image[],
                public categorie?:Categorie){}
}