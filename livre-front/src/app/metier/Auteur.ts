import { Livre } from './Livre';

export class Auteur{
    constructor(public id : number,public nom : string,public prenom : string,public livres ? : Livre[]){}
}