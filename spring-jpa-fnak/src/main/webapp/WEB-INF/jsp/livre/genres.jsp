<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des genres</title>
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
					<a class="navbar-brand" href="#">Liste des genres</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="http://localhost:8080/create">Creation d'un livre</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/">Liste des livres</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/{genre.id}/genres">Liste des
									genres</a></li>

						</ul>
					</div>
				</nav>
			</div>
		</div>
		<br>
				<div class="row">
			<div class="col-md-2">
				<a href="/"  class="btn btn-warning" class="ml-3"><img src="/image/reply.png" /></a>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-12 ">
				<div class="card shadow rounded" style="width: 90rem;">
					<div class="card-body">
						<h2 class="card-title text-center"><b> ${livre.titre}</b></h2>
						<p class="card-text text-center">Ecrit par :<b> ${livre.auteur.prenom }
							${livre.auteur.nom }</b></p>
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
						<h5 class="card-title text-center">Genre déjà associés :</h5>
						<h3 class="card-title text-center">${livre.titre}</h3>
						<hr>
						<p class="card-text text-center">Cliquer pour retirer</p>
						<div class="card-text">
							<c:forEach items="${selected_genres}" var="sg">
								<form action="/livre/removeGenre" method="post">
									<input type="hidden" name="livreId" value="${livre.id}" />
									<input type="hidden" name="genreId" value="${sg.id}" />
									<input type="submit"class="mb-2 btn-block btn btn-sm btn-primary" value="${sg.libelle}">
								</form>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 offset-md-3">
				<div class="card shadow rounded" style="width: 42rem;">
					<div class="card-body">
						<h5 class="card-title text-center">Genre non associés :</h5>
						 <h3 class="card-title text-center">${livre.titre}</h3>
						<hr>
						<p class="card-text text-center">Cliquer pour retirer</p>
						<div class="card-text">
							<c:forEach items="${unselected_genres}" var="usg">
								<form action="/livre/addGenre" method="post">
									<input type="hidden" name="livreId" value="${livre.id}" />
									<input type="hidden" name="genreId" value="${usg.id}" />
									<input type="submit"class="mb-2 btn-block btn btn-sm btn-primary" value="${usg.libelle}">
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