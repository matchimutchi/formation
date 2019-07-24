/*
function toto(){
}
window.toto = function(){
}   */

// Produit ( arguments)
function Produit(nom, prix, poids){
    //getter setter
    this.nom = nom;
    this.prix = prix;
    this.poids = poids;

    this.toString = function(){
        return "Produit = Nom : " + this.nom + " Prix : " + this.prix + " Poids : " + this.poids;

    };
}

function test1(){
    var p1 = new Produit("steack de lama", 19.99, 0.75);
    console.log(p1.toString());

    //heritage de class
    //je creer un objet ps1 qui a pour prototype p1
    var ps1= Object.create(p1);
    console.log(ps1.toString());

    //changer la valeur d'un attribut
    ps1.poids = 0.65;
    console.log(ps1.toString());

    p1.prix = 22.99;
    console.log(ps1.toString());

    delete ps1.poids;
    console.log(ps1.toString());

    ps1.categorie = "Boucherie";
    console.log(ps1.toString());
}

//function globale (objet window)
function test2(){
    var bob = new Personne("Eponge", "Bob");
    console.log(bob.toString());

    var patrick = new Client("Etoile", "Patrick", "patrick@etoile.com");
    console.log(patrick.toString());
    patrick.contacter();
}


//LAMBDA
function test3(){
    //je met une fonction dans une variable
    var fct1 = function(){
        console.log("Bonjour depuis fct1");
    };
    //je peux l'appeler ensuite
    fct1();

    // même regle d'affection que les types classique
    var fct2 = fct1;
    fct2();

    //la variable est de type fonction
    console.log(typeof fct1);

    var fctCapitalise = function(chaine){
        return chaine.charAt(0).toUpperCase() + chaine.substr(1);
    }

    var salutation = function(nom, pretraitement){
        console.log("Bonjour, " + pretraitement(nom));
    }


    //comme un lambda peut être passer en parametre à une autre fonction pour être appele
    salutation("jennifer " , fctCapitalise);

    var tabclient = [];
    tabclient.push(new Client("eponge", "bob","bob@yahoo.fr"));
    tabclient.push(new Client("etoile", "patrick","pat@yahoo.fr"));
    tabclient.push(new Client("tentacule", "carlo","carlo@yahoo.fr"));
    tabclient.push(new Client("ecureuil", "sandy","sandy@yahoo.fr"));

    tabclient.sort(function(c1,c2){
        return c1.prenom.localeCompare(c2.prenom);
    });

    console.log(tabclient);
}


function initialiser(){
    var compteur = 1;

    //closure
    window.incrementer = function(){
        compteur++;
        this.console.log("compteur = " + compteur);
    }
}

function augmenter(){
    incrementer();
}

function test4(){
    var nom = document.getElementById("nom").value;
    var compteur = 1;
    //setInterval demande au navigateur de rappeler la fonction en paramtre
    // tout les x milliseconde
    window.setInterval(function(){
        console.log(nom + " : " + compteur++);
    }, 2000);
}

function Article(nom,prix,poids){
    //attribut "publique"
    this.nom = nom;

    this.getPrix = function(){
        return prix;
    }

    this.setPrix = function(nPrix){
        prix = nPrix;
    }

    this.getPoids = function(){
        return poids;
    }

    this.toString = function(){
        return " Nom = " + this.nom + " Prix = " + this.getPrix() + " Poids = " + this.getPoids();
    }
}

function test5(){
    var a1 = new Article("tie fighter", 15000, 2300);
    console.log(a1.toString());
    console.log(a1.poids);
    console.log(a1.getPoids());
    a1.setPrix(13500);
    console.log(a1.getPrix());


}