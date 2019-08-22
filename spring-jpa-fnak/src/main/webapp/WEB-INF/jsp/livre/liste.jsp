<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Livres jpa</title>
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
					<a class="navbar-brand" href="#">Livres jpa</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="http://localhost:8080/home">Détail des livres</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/">Liste des livres</a></li>

						</ul>
					</div>
				</nav>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<form id="searchform" action="search">
					<div class="row">
						<div class="col-md-2 offset-md-10 mt-4">
							<a class="btn btn-primary shadow  rounded" href="/create"
								role="button">Créer un livre</a>
						</div>
					</div>
				</form>
				<br>
				<table class="table  table-hover shadow p-3 mb-5 rounded">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Titre</th>
							<th scope="col">ISBN</th>
							<th scope="col">nbPages</th>
							<th scope="col">Auteur</th>
							<th scope="col">Genres</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${livres}" var="l">
							<tr>
								<td>${l.id}</td>
								<td>${l.titre}</td>
								<td>${l.isbn}</td>
								<td>${l.nbPages}</td>

								<td><a href="https://fr.wikipedia.org/wiki/${l.auteur.prenom}_${l.auteur.nom}"
									target="blanck_">${l.auteur.prenom} ${l.auteur.nom} 
									</a>
								</td>
								<td>
								<c:forEach items="${l.genres}" var="genre" varStatus="v">

										<c:if test="${v.last}">
											${genre.libelle} 
										</c:if>
										<c:if test="${not v.last}">
											 ${genre.libelle}  -
										</c:if>
									</c:forEach>
								</td>
								<td>
									<a style="float: left; margin-right: 5px"
									class="btn btn-primary" href="/livre/${l.id}/editgenres" role="button">Etiquetage</a>
									<a style="float: left; margin-right: 5px"
									class="btn btn-warning" href="/edit/${l.id}" role="button">Edition</a>
									<form action="/delete" id="delete" method="post"
										style="float: left">
										<input type="hidden" name="delete" value="${l.id}"> <input
											class="btn btn-danger" type="submit" id="delete"
											value="Supprimer" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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