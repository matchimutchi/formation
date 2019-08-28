import { Auteur } from './Auteur';

export class Livre{
    constructor(public id : number,public titre : string,public nbPages : number,public isbn : String,public dateSortie : Date, public auteur? : Auteur){}
}