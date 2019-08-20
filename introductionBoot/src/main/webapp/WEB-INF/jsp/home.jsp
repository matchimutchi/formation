<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Une page jsp</title>
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
					<a class="navbar-brand" href="#">Détail des Produits</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active">
							<a class="nav-link" href="http://localhost:8080/bonjour">Détail des produits</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="http://localhost:8080/liste">Liste des produits</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<br>
		<br>
		<!-- DEBUT TITRE -->
		<!-- <div class="row">
			<div class="col-md-6 offset-md-4">
				<h2>Beinvenue sur ma page HOME</h2>
			</div>
		</div>-->
		<!-- FIN TITRE -->
		<br>
		<br>
		<!-- DEBUT INJECTION -->
		<div class="row">
			<div class="col-md-3 offset-md-1">
				<div class="card text-white bg-dark shadow p-3 mb-5  rounded text-center" style="width: 20rem;">
					<img src="/image/steack2.jpg" class="card-img-top" alt=""> 
					<div class="card-body">
						<h5 class="card-title" style="text-align:center">${titre}</h5>
						<hr style="border-top: 1px solid white">
						<p class="card-text">${prix}</p>
						<p class="card-text">${poids}</p>
						<br>
						<a href="#" class="btn btn-warning" style="text-align:center">Ajouter</a>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-white bg-dark shadow p-3 mb-5  rounded text-center" style="width: 20rem;">
					<img src="/image/biere.jpg" class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title" style="text-align:center">${titre2}</h5>
						<hr style="border-top: 1px solid white">
						<p class="card-text">${prix2}</p>
						<p class="card-text">${poids2}</p>
						<br>
						<a href="#" class="btn btn-warning" style="text-align:center">Ajouter</a>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-white bg-dark shadow p-3 mb-5 rounded text-center" style="width: 20rem;">
					<img src="/image/i25832-filets-de-poulet-en-urgence.jpg" class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title" style="text-align:center">${titre1}</h5>
						<hr style="border-top: 1px solid white">
						<p class="card-text">${prix1}</p>
						<p class="card-text">${poids1}</p>
						<br>
						<a href="#" class="btn btn-warning " style="text-align:center">Ajouter</a>
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