<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edition d'un acteur</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar  navbar-dark bg-dark">
					<a class="navbar-brand" href="#">Edition - Création d'un acteur</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="http://localhost:8080/">Liste des films</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/home">Liste des acteurs</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/accueil">Liste des réalisateurs</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<br> <br>

		<!-- DEBUT INJECTION -->
		<div class="row">
			<div
				class="col-md-6 offset-md-1 text-white shadow p-3 mb-5 bg-dark rounded">
				<form action="/saveActeur" method="post">
					<div class="form-group">
						<input type="hidden" class="form-control" id="id" name="id"
							value="${acteur.id}">
					</div>
					<div class="form-group">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" name="nom" id="nom"
							value="${acteur.nom}">
					</div>
					<div class="form-group">
						<label for="prenom">Prenom</label>
						<input class="form-control" name="prenom" id="prenom" value="${acteur.prenom}">

					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							class="form-control" name="email" id="email"
							value="${acteur.email}">
					</div>
									
					<br>
					<div class="form-group">
						<input type="submit" class="btn btn-warning" value="Sauvegarder">
						<a href="http://localhost:8080/home" class="btn btn-danger">Retour</a>

					</div>
				</form>

			</div>

			<div class="col-md-4 offset-md-1 ">
				<div class="card text-white shadow p-3 mb-5 bg-dark rounded"
					style="width: 19rem;">
					<img src="/image/paris.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">${acteur.nom}</h5>
						<p class="card-text">
							<b>Prenom</b> : ${acteur.prenom}
						</p>
						<p class="card-text">
							<b>Email</b> : ${acteur.email}
						</p>
					</div>
				</div>
			</div>
		</div>

		<!-- FIN INJECTION -->
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>