$(document).ready(function(){

    console.log("Démarrage de l'application");
    requestLivres("");
  //  requestnbPages(0);


    $("#createForm").hide();
    $("#editLivre").hide();
    $("#btShow").click(function(){
        $("input#id").val(0);
        $("input#titre").val("");
        $("input#isbn").val("");
        $("input#nbPages").val(0);
        $("input#auteur").val("");
        $("#createForm").show();
        $("#editLivre").hide();
        $("#supLivre").hide();
        $("#addLivre").show();
    });

    $("#supLivre").hide();

    $("#addLivre").click(saveLivre);

    $("#editLivre").click(saveLivre);

    $("#editLivre").click(function(){
        $('#exampleModal').modal('hide');
        $('div.modal-backdrop').modal('hide');
    });

    $("#supLivre").click(deleteLivre);

    $("#supLivre").click(function(){
        $('#exampleModal').modal('hide');
        $('div.modal-backdrop').modal('hide');
    });

    $("#swith").click(function(){
        if (typesearch == "titre") {
            $(this).text("Recherche par Titre");
            $("#recherche").text("Recherche NbPages ");
            typesearch= "filter";
        }
        else {
            $(this).text("Recherche NbPages"); 
            $("#recherche").text("Recherche Titre ");
            typesearch="titre";
        }
        $("input#search").val("");
    });

    
    $("#addLivre").click(function(){
        $('#exampleModal').modal('hide');
        $('div.modal-backdrop').modal('hide');
    });

});



function saveLivre(){
    var id = $("input#id").val();
    var titre = $("input#titre").val();
    var isbn = $("input#isbn").val();
    var nbPages = $("input#nbPages").val();
    var auteur = $("input#auteur").val();

    jQuery.post('livre', {  "id": id,
                            "titre" : titre,
                            "isbn" : isbn,
                            "nbPages" : nbPages,
                            "auteur" : auteur},
                        function (data) {
                            //quand reponse du seveur
                            console.log("nb lignes = " + data.nblignesSauvees);
                            forceRefresh = true;
                        });
    return false;
   
}


var forceRefresh = false;
var searchPrevious = "";
var filterPrevious = 0;
var typesearch = "titre";


function checkSearch(){
   var newsearch =  $("input#search").val();
   if(newsearch != searchPrevious || forceRefresh){
       forceRefresh = false;
       console.log("Nouvelle rechercher : " + newsearch);
       searchPrevious = newsearch;
       requestLivres(newsearch);

   }else{
       console.log("Pas de changement");
        window.setTimeout(checkSearch,1000);
   }

}


function requestLivres(search){
    var url = 'livre';
    if(search != null && search.length > 0){
       if(typesearch == "titre"){
         url += '?search=' + search;
       }
        else{
            url += '?filter=' + search;
        }
        
    }
   jQuery.getJSON(url, function(data){
        fillLivreTable(data);
        window.setTimeout(checkSearch,1000);
    });
    
}






function fillLivreTable(data){
    console.log(data);

    var tbody = $("table#tableLivres tbody");
    tbody.empty();
    for(let livre of data){
        var tr = $("<tr class=\"vue\"></tr>");
        tr.append("<td>" + livre.id +"</td>");
        tr.append("<td>" + livre.titre +"</td>");
        tr.append("<td>" + livre.isbn +"</td>");
        tr.append("<td>" + livre.nbPages +"</td>");
        tr.append("<td>" + livre.auteur +"</td>");

        var button = $("<button class=\"btn btn-warning shadow rounded\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@mdo\"><ion-icon name=\"create\"></ion-icon><b>Editer</b></button>");
        var td = $("<td></td>");
        td.append(button);
        tr.append(td);

        tbody.append(tr);

        button.click(function(){
            $("#createForm").show();
            $("input#id").val(livre.id);
            $("input#titre").val(livre.titre);
            $("input#isbn").val(livre.isbn);
            $("input#nbPages").val(livre.nbPages);
            $("input#auteur").val(livre.auteur);
            $("#addLivre").hide();
            $("#editLivre").show();
            $("#supLivre").show();
    
        });


    }
 
}

function deleteLivre(){
    var id = $("input#id").val();
    jQuery.post('supprimer', { "id": id},
                        function (data) {
                            console.log("nb lignes = " + data.nbLignesupprime);
                            forceRefresh = true;
                        });
    return false;
   
}



