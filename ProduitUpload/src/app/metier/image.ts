import { Produit } from './produit';

export class Image{
    constructor(public id: number,
                public nom :string,
                public filename : string,
                public contentType : number,
                public produits?:Produit[]){}
}