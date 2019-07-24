/*

classe Personne
*/

function Personne(nom,prenom){
    this.nom = nom;
    this.prenom = prenom;


}

//Cela va contenir les fonctions
Personne.prototype = Object.create({constructor : Personne});
Personne.prototype.toString = function(){
    return "Nom : "+ this.nom + " Prénom : " + this.prenom;
}
/*

classe Client qui herite de Personne
*/
function Client(nom,prenom,email){
    //on rappele les arguments du parent comme super() dans java
    Personne.call(this, nom,prenom,);
    this.email = email;
}

//le new creer un objet vide et appelle la fonction 


Client.prototype = Object.create(Personne.prototype);
Client.prototype.constructor = Client;
Client.prototype.contacter = function(){
    console.log("Envoie email à " + this.nom + " "+ this.prenom +  " son adresse email est " + this.email);
}