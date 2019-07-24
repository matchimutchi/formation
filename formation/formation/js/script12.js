
function init() {
    document.getElementById("add").addEventListener("click", test2);
}


function test1(){
    var menage = new Tache("Menage", "Lavage de printemps");
    console.log(menage.toString());

    var rdv = new Priorite("Rendez-vous", "Radio", "5");
    console.log(rdv.toString());
    rdv.contacter();

    var mecanique = new Etat("Rendez-vous", "Mecanique", "8", "Planifier");
    console.log(mecanique.toString());
    mecanique.contacter();

}

// function refreshTodoList() {
//     var todos = document.getElementById("todos");
//     // todos.innerHTML = "";
//     for (var idx in todolist) {
//         var div = document.createElement("div");
//         div.innerText = todolist[idx];
//         div.className="divtodo";
//         div.setAttribute('data-idx', "" + idx);
//         todos.appendChild(div);
//         div.addEventListener("click", removeTodoList);
//     }
// }


// function addTodoList() {
//     var titre = document.getElementById("titre").value;
//     var description = document.getElementById("description").value;
//     var priorite = document.getElementById("priorite").value;
//     var etat = document.getElementById("etat").value;
//     todolist = [titre,description,priorite,etat];
//     refreshTodoList();
// }

function test2(){
    var titre = document.getElementById("titre").value;
    var description = document.getElementById("description").value;
    var priorite = document.getElementById("priorite").value;
    var etat = document.getElementById("etat").value;
    todolist = [titre,description,priorite,etat];
    var todos = document.getElementById("todos");
    for (var idx in todolist) {
                var div = document.createElement("div");
                var button = document.createElement("button");
                div.innerText = todolist[idx];
                div.className="divtodo";
                div.setAttribute('data-idx', "" + idx);
                button.typeName="submit";
                
                todos.appendChild(div);
                todos.appendChild(button);
                
                // div.addEventListener("click", removeTodoList);
            }
   
    console.log(todolist);

    // todolist.sort(function(c1,c2){
    //     return c1.etat.localeCompare(c2.etat); 
      
     
    // });
            
    // console.log(todolist);
}

// function removeTodoList() {
//     this.removeEventListener("click", removeTodoList);
//     var pos = Number(this.getAttribute('data-idx'));
//     todolist.splice(pos, 1);
//     refreshTodoList();
//     return false;
// }




