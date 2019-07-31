$(document).ready(function(){

    console.log("Démarrage de l'application");
    requestFilms("");
    // checkSearch();
});

var searchPrevious = "";


//search
function checkSearch(){
   var newsearch =  $("input#search").val();
   if(newsearch != searchPrevious){
       console.log("Nouvelle rechercher : " + newsearch);
       searchPrevious = newsearch;
       requestFilms(newsearch);

   }else{
       console.log("Pas de changement");
        //reverifier dans une seconde
        window.setTimeout(checkSearch,1000);
   }

}


function requestFilms(search){
    var url = 'film';
    if(search != null && search.length > 0){
        url += '?search=' + search;
    }
   jQuery.getJSON(url, function(data){
        fillFilmTable(data);
        window.setTimeout(checkSearch,1000);
    });
    
}

function fillFilmTable(data){
    console.log(data);

    console.log(data);
    var tbody = $("table#tableFilms tbody");
    tbody.empty();
    for(let film of data){
        var tr = $("<tr></tr>");
        tr.append("<td>" + film.id +"</td>");
        tr.append("<td>" + film.titre +"</td>");
        tr.append("<td>" + film.longueur +"</td>");
        tr.append("<td>" + film.annee +"</td>");
        tr.append("<td>" + film.genre +"</td>");
        tbody.append(tr);
    }

    
}