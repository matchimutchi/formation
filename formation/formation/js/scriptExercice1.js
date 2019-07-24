function init(){
    document.getElementById("ajout").addEventListener("click", addEmail);
}


function test1(){
    var elem = document.getElementById("message");
    var choix = document.getElementById("choix").value;
    // var  = champ;
    var nombre = Number(choix);
    var choix1 = document.getElementById("choix1").value;
    //var choix1 = champ1.value;
    var nombre1 = Number(choix1);

    console.log("addition("+ choix +"+" + choix1+") -> " + addition(nombre,nombre1));
    elem.innerText = "Le résultat de " + choix + " + " + choix1 +" = " +addition(nombre,nombre1);
}

function addition(x ,y){
    return x + y;
}


//----------------------SOUSTRACTION
function test2(){
    var elem = document.getElementById("message");
    var choix = document.getElementById("choix").value;
    //var choix = champ.value;
    var nombre = Number(choix);
    var choix1 = document.getElementById("choix1").value;
   // var choix1 = champ1.value;
    var nombre1 = Number(choix1);

    console.log("soustraction("+ choix +"-" + choix1+") -> " + soustraction(nombre,nombre1));
    elem.innerText = "Le résultat de " + choix + " - " + choix1 +" = " +soustraction(nombre,nombre1);
}

function soustraction(x ,y){
    return x - y;
}

//---------------------------MULTIPLICATION
function test3(){
    var elem = document.getElementById("message");
    var choix = document.getElementById("choix").value;
    //var choix = champ.value;
    var nombre = Number(choix);
    var choix1 = document.getElementById("choix1").value;
    //var choix1 = champ1.value;
    var nombre1 = Number(choix1);

    console.log("multiplication("+ choix +"*" + choix1+") -> " + multiplication(nombre,nombre1));
    elem.innerText = "Le résultat de " + choix + " * " + choix1 +" = " + multiplication(nombre,nombre1);
}

function multiplication(x ,y){
    return x * y;
}


//-------------DIVISION
function test4(){
    var elem = document.getElementById("message");
    var choix = document.getElementById("choix").value;
   // var choix = champ.value;
    var nombre = Number(choix);
    var choix1 = document.getElementById("choix1").value;
    //var choix1 = champ1.value;
    var nombre1 = Number(choix1);

    console.log("division("+ choix +"/" + choix1+") -> " + division(nombre,nombre1));
    elem.innerText = "Le résultat de " + choix + " / " + choix1 +" = " +division(nombre,nombre1);
}

function division(x ,y){
    return x / y;
}



//-----------------------------EMAIL
function addEmail(evt){
    var pattern = /^[a-zA-Z0-9]+([.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)*([.][a-zA-Z0-9]{2,4})$/i;
    var saisie = document.getElementById("email").value;
    if(pattern.test(saisie) ){
        var div = document.createElement("div");
        div.innerText = saisie;
        div.className = "divemail";
        var listeemails = document.getElementById("listeemails");
        listeemails.appendChild(div);
        div.addEventListener("click", removeEmail);
        document.getElementById("email").className="valide";
    }else{
        document.getElementById("email").className="invalide";
    }

    evt.preventDefault();
    return false;
}

function removeEmail(evt){
    this.removeEventListener("click", removeEmail);
    document.getElementById("listeemails").removeChild(this);

    evt.preventDefault();
    return false;

}

// function ajoutli(){
//     //je recupere la balise input
//     var champsaisie = document.getElementById("saisie");
//     var saisie = champsaisie.value;
//     console.log(saisie);
//     var ul = document.getElementById("listechoix");
//     var li = document.createElement("li");
//     ul.className = "visible";
//     var saisiecode = saisie;
//     var texte = document.createTextNode(saisiecode);
//     var pattern = /^[a-zA-Z0-9]+([.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)*([.][a-zA-Z0-9]{2,4})$/i;
//     //  console.log(typeof(pattern));
//      console.log("email est-il valide ? " + pattern.test(saisiecode));
//      if(pattern.test.saisiecode == true){
//         li.appendChild(saisiecode);
//         ul.appendChild(li);
//      }else{
//          console.log("erreur");
//      }

    
// }


// function supprimeli(){
//     var liste=document.getElementById("listechoix").getElementsByTagName("li");
 
// for(li in liste){
// 	liste[li].onclick=function(){
// 		this.parentNode.removeChild(this);
// 	}
// }
//     //li.parentNode.removeChild(li);
// //     var node = document.getElementById("listechoix").firstChild;
// // if (node.parentNode) {
// //   node.parentNode.removeChild(node);
// }


