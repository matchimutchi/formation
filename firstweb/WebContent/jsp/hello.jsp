<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello!</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">JAVASCRIPT</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Navigation
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" target="_blanck" href="http://localhost:8080/firstweb/index.html">Accueil</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" target="_blanck" href="http://localhost:8080/firstweb/HelloServlet">Servlets</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" target="_blanck" href="http://localhost:8080/firstweb/jsp/hello.jsp">JSP</a>
          	<div class="dropdown-divider"></div>
            <a class="dropdown-item" target="_blanck" href="http://localhost:8080/webjdbcdao/jsp/liste.jsp">Film</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <br>
  <div class="row">
  	<div class="col-md-6 offset-md-4">
		<h2>Bienvenue sur la page JSP</h2>
	</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h5>
				Nous somme le <%= LocalDateTime.now() %>
			</h5>
		</div>
		<div class="col-md-2 offset-md-1">
		<h3>Compteur</h3>
			<ul>
				<%
					for(int i = 1; i <= 10 ; i++){
				%>
					<li>i : <%= i %></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
	<br>
	<hr>
	<br>
	<div class="row">
		<div class="col-md-12">
			<form method="post" action="../CalculServlet">
				<div class="row">
					<div class="col-md-3 offset-md-1">
					<h5>Choix de nombre</h5>
						<label for="operande1">Operande 1</label>
						<input style="width:250px" type="number" name="operande1" id="operande1"/>
						<label for="operande2">Operande 2</label>
						<input style="width:250px" type="number" name="operande2" id="operande2"/>
					</div>
					<div class="col-md-6">
					<h5>Choix de l'opérateur</h5>
						<select name="operateur" id="operateur" style="width:250px">
							<option value ="+" selected="selected">Addition</option>
							<option value ="-">Soustraction</option>
							<option value ="*">Multiplication</option>
							<option value ="/">Division</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Valider</button>
				</div>
			</form>
		</div>
	</div>
	
</body>

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>