<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des films</title>
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
					<a class="navbar-brand" href="#">Liste des films</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="http://localhost:8080/home">Liste des acteurs</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/">Liste des films</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/accueil">Liste des
									realisateurs</a></li>

						</ul>
					</div>
				</nav>
			</div>
		</div>
		<br>
				<div class="row">
			<div class="col-md-2">
				<a href="/accueil"  class="btn btn-warning" class="ml-3"><img src="/image/reply.png" /></a>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-12 ">
				<div class="card shadow rounded" style="width: 90rem;">
					<div class="card-body">
						<h2 class="card-title text-center">Realiser par : <b> ${realisateur.nom}</b></h2>
						<p class="card-text text-center"><b> ${realisateur.film.prenom }
							${realisteur.film.nom }</b></p>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>

		<div class="row">
			<div class="col-md-3">
				<div class="card shadow rounded" style="width: 42rem;">
					<div class="card-body">
						<h5 class="card-title text-center">Film déjà associés :</h5>
						<h3 class="card-title text-center">${realisateur.nom}</h3>
						<hr>
						<p class="card-text text-center">Cliquer pour retirer</p>
						<div class="card-text">
							<c:forEach items="${selected_realisateurs}" var="sg">
								<form action="/realisateur/removeFilm" method="post">
									<input type="hidden" name="realisateurId" value="${realisateur.id}" />
									<input type="hidden" name="filmId" value="${sg.id}" />
									<input type="submit"class="mb-2 btn-block btn btn-sm btn-primary" value="${sg.nom}">
								</form>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 offset-md-3">
				<div class="card shadow rounded" style="width: 42rem;">
					<div class="card-body">
						<h5 class="card-title text-center">Film non associés :</h5>
						 <h3 class="card-title text-center">${realisateur.nom}</h3>
						<hr>
						<p class="card-text text-center">Cliquer pour retirer</p>
						<div class="card-text">
							<c:forEach items="${unselected_realisateurs}" var="usg">
								<form action="/realisateur/addFilm" method="post">
									<input type="hidden" name="realisateurId" value="${realisateur.id}" />
									<input type="hidden" name="filmId" value="${usg.id}" />
									<input type="submit"class="mb-2 btn-block btn btn-sm btn-primary" value="${usg.nom}">
								</form>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
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