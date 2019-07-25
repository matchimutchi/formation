<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition des films</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Servlets et base de donnée</a>
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
            <a class="dropdown-item" target="_blanck" href="http://localhost:8080/webjdbcdao/FilmServlet/*">1 - Liste Film</a>
          	<div class="dropdown-divider"></div>
          	<a class="dropdown-item" target="_blanck" href="http://localhost:8080/webjdbcdao/FilmServlet/?">1 - Edition film</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <br>
  <br>
  <div class="row">
  		<div class="col-md-6 offset-md-4">
			<h2>Votre film</h2>
		</div>
	</div>
	<br>
	<br>
	 <div class="row">
  		<div class="col-md-10 offset-md-1">
			<form method="post" action="/webjdbcdao/FilmServlet/">
			<table>
				<tr>
					<td><input type="hidden" name="id" id="id" value="<c:out value='${requestScope.film.id}'></c:out>"/></td>
				</tr>
				<tr>
					<td class="text-right"><label for="titre"><b>Titre : </b>&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="text" name="titre" id="titre" value="<c:out value='${requestScope.film.titre}'></c:out>"/></td>
				<tr>
				<tr>
					<td class="text-right"><label for="longueur"><b>Longueur : </b>&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="number" name="longueur" id="longueur" value="<c:out value='${requestScope.film.longueur}'></c:out>"/></td>
				<tr>
				<tr>
					<td class="text-right"><label for="annee"><b>Année : </b>&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="number" name="annee" id="annee" value="<c:out value='${requestScope.film.annee}'></c:out>"/></td>
				<tr>
				<tr>
					<td class="text-right"><label for="genre"><b>Genre : </b>&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="text" name="genre" id="genre" value="<c:out value='${requestScope.film.genre}'></c:out>"/></td>
				<tr>
				</table>
				<br>
					<button style="margin-right:5%" type="button" class="btn btn-warning btn-lg"><a href="http://localhost:8080/webjdbcdao/FilmServlet/*" style="text-decoration:none;color:black;font-weight:bold">Retour</a></button>
					<input type="submit" class="btn btn-primary btn-lg" value="Sauver"/>
			</form>
		</div>
	</div>

	
</body>

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>