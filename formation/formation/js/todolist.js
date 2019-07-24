/*

classe Personne
*/

function Tache(titre,description){
    this.titre = titre;
    this.description = description;
    // this.priorite = priorite;
    // this.etat = etat;

}


Tache.prototype = Object.create({constructor : Tache});
Tache.prototype.toString = function(){
    return "Titre : "+ this.titre + " Description : " + this.description ;
    // "Priorité : "+ this.priorite + " Etat : " + this.etat;
}


function Priorite(titre,description,priorite){

    Tache.call(this,titre,description);
    this.priorite = priorite;
}


Priorite.prototype = Object.create(Tache.prototype);
Priorite.prototype.constructor = Priorite;
Priorite.prototype.contacter = function(){
    console.log("Titre : "+ this.titre + " Description : " + this.description +"Priorité : "+ this.priorite );
}

function Etat(titre,description,priorite,etat){

    Priorite.call(this,titre,description,etat);
    this.etat = etat;
}


Etat.prototype = Object.create(Priorite.prototype);
Etat.prototype.constructor = Etat;
Etat.prototype.contacter = function(){
    console.log("Titre : "+ this.titre + " Description : " + this.description +" Priorité : "+ this.priorite +  " Etat : " + this.etat);
}

