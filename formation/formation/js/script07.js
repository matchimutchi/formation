


function test1(){
    //mot clé var permet de déclarer un variable

    var a = 15;
    console.log(" a = " + a);
    console.log("type de a = " + typeof(a));
    a = "hello";
    console.log(" a = " + a);
    console.log("type de a = " + typeof(a));

    var b;// une variable non "définie" est de type 'undefined'
    console.log(" b = " + b);
    console.log("type de b = " + typeof(b));

    var c = true;
    console.log(" c = " + c);
    console.log("type de c = " + typeof(c));

    var d = 3.145;
    console.log(" d = " + d);
    console.log("type de d = " + typeof(d));

    //les objets
    var e = {
        "Nom" : "Steack de lama des andes",
        "Prix" : 19.99 + " euros"
    };

    console.log(" type de e = " + typeof(e));
    console.log(e);

    e = null;
    console.log(" type de e = " + typeof(e));
    console.log(e);

    // si j'affecte undefined, le type passe aussi a undefined
    e = undefined;
    console.log(" type de e = " + typeof(e));
    console.log(e);

    //En javascript les tableaux sont des objects "spéciaux"
    var g = [1, 2, 3, 4];
    console.log(g);
    console.log(" type de g = " + typeof(g));
    
}

function test2(){
    var a,b,c;

    a = 10;
    b = 15;
    c = "3";

    var result = a + b + c;
    console.log("resultat = " + result);

    var result = c + a + b;
    console.log("resultat = " + result);


    a = 3;
    b = 3;

    console.log("(a == b) -> " + (a == b));
    console.log("(a == c) -> " + (a == c));
    
    //egalité stricte valeur et type
    console.log("(a === b) -> " + (a === b));
    console.log("(a === c) -> " + (a === c));  

    console.log("(undefined == null) -> "+ (undefined == null));
    console.log("(undefined === null) -> "+ (undefined === null));

    //le type d'une fonction est funtion
    // en javascript les fonctions sont traitée comme des variables
    // contenant du code
    console.log("type de test1 -> " + typeof(test1));
    console.log("Le contenu  de test1" + test1);
}

function test3(){
    // appel de fonction avec parametres
    
    console.log("multiplication(3,4, 5) -> " + multiplication(3,4, 5));
    console.log("multiplication(3) -> " + multiplication(3));
    console.log(moyenne(3,12,15));

    var tab1 = ["lundi", "mardi", "mercredi"];
    //tab1.poulet = "frites";
    for(prop in tab1){
        //cela n'affichera que l'index des objets
        //console.log(prop);
        console.log(prop +" -> "+tab1[prop]);
    }

    //introduit plus recemment : le for/of
    //ne marche que sur les iterable
    for( value of tab1){
        console.log(value);
    }

    var obj1 = {
        "Nom" : "Steack des lamas des andes",
        "Prix" : 19.99 + "Euros",
        "Poids" : 0.75 +"kg",
        "toString": function(){
            // ejavascript , le this est obligatoire
           return "produit '" + this.Nom + "' de prix " + this.Prix;
        }

    }

    //je peux aussi enumerer les propriétés d'un objet 
    for(prop in obj1){
        console.log(prop +" -> " + obj1[prop]);
    }

    console.log(obj1.toString());

    var i = 0;
    while( i < 10){
        i++;
        console.log("i = " + i);
        if(i == 6){
            break;
        }
    }
}

function multiplication(x ,y){
    // si le parametre y est non présent, un par defaut
    if(y === undefined){
        y = 1;
    }
    // fait la meme chose qu'au debut mais ce code est a eviter
    // y = y || 1;
    return x * y;
}

function moyenne(){
    // console.log(arguments);
    if(arguments.length == 0){
        return NaN;
    }
    var total = 0;
    for(var idx = 0 ; idx < arguments.length; idx++){
        total += arguments[idx];
    }
    return total / arguments.length;
}