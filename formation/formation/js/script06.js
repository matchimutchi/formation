//ouvre un popup
//javascript (sauf webworker) est monothread
//c'est a dire qu'il n'y a dans la page qu'une seule execution du javascript
// alert est un popup qu'on appelle  modal
// cela bloque l'execution de javascript en attendant le click de l'utilisateur
//c'est la premiere et derniere fois qu'on utilisera alert
//alert('Bonjour depuis javascript');

console.log('Bonjour depuis la consol de javascript');


function test1(){
    console.log('Vous avez cliquez le ' + new Date());
    document.getElementById('message').innerText = "Salut nous sommes le " + new Date();
}