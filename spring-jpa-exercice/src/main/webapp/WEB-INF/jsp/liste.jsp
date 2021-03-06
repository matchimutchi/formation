<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste de mes postes</title>
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
					<a class="navbar-brand" href="#">Liste de mes postes</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link"
								href="http://localhost:8080/home">D�tail des postes</a></li>
							<li class="nav-item"><a class="nav-link"
								href="http://localhost:8080/">Liste des postes</a></li>

						</ul>
					</div>
				</nav>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<form id="searchform" action="search">
					<div class="row">
						<div class="col-md-2 ">
							<label for="search">Recherche par post</label> 
							<input type="text" class="shadow rounded" id="search" name="search">

						</div>
						<div class="col-md-1 mt-4">
							<input type="submit" class="btn btn-warning shadow  rounded" value="Search">
						</div>
						<div class="col-md-1 mt-4">
							<a href="/liste" class="btn btn-danger shadow  rounded">Retour</a>
						</div>
						<div class="col-md-2 offset-md-6 mt-4">
							<a class="btn btn-primary shadow  rounded" href="/create"
								role="button">Cr�er d'un post</a>
						</div>
					</div>
				</form>
				<br><br>
				<table class="table table-dark shadow p-3 mb-5 rounded">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Titre</th>
							<th scope="col">Corps</th>
							<th scope="col">Date Creation</th>
							<th scope="col">Auteur</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${posts}" var="p">
							<tr>
								<td>${p.id}</td>
								<td>${p.titre}</td>
								<td>${p.corps}</td>
								<td>${p.dateCreation} </td>
								<td>${p.auteur}</td>
								<td><a style="float: left; margin-right: 5px"
									class="btn btn-warning" href="/edit/${p.id}" role="button">Edition</a>
									<form action="/delete" id="delete" method="post"
										style="float: left">
										<input type="hidden" name="delete" value="${p.id}"> <input
											class="btn btn-danger" type="submit" id="delete"
											value="Supprimer" />
									</form></td>
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