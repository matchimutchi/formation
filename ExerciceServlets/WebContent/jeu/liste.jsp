<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Jeux</title>
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
          <a class="nav-link dropdown-toggle" style="color:white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Navigation
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">  
            <a class="dropdown-item" target="_blanck" href="http://localhost:8080/webjdbcdao/">1 - Film</a>
          	<div class="dropdown-divider"></div>
          	<a class="dropdown-item" target="_blanck" href="http://localhost:8080/ExerciceServlets/">2 - Jeux</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <br>
  <br>
  <div class="row">
  		<div class="col-md-6 offset-md-5">
			<h2>Les meilleurs Jeux</h2>
		</div>
	</div>
	<br>
	<br>
	 <div class="row">
  		<div class="col-md-10 offset-md-1">
			<table class="table table-striped table-hover" border="1">
				<thead>
					<tr class="bg-dark" style="color:white;text-align:center">
						<th scope="col">Id</th>
						<th scope="col">Titre</th>
						<th scope="col">Description</th>
						<th scope="col">Platforme</th>
						<th scope="col">Annee Sortie</th>
						<th scope="col">Actions</th>
						<th scope="col">Trier par jeux de plateforme</th>
						<th scope="col">Supprision</th>
					</tr>
				</thead>
				<tbody>
				<!-- requestScope signifie va regarder dans request -->
					<c:forEach items="${requestScope.jeux}" var="jeu">
						<tr>
							<td style="text-align:center"><c:out value="${jeu.id}"></c:out></td>
							<td style="text-align:center"><c:out value="${jeu.titre}"></c:out></td>
							<td style="text-align:center"><c:out value="${jeu.description}"></c:out></td>
							<td style="text-align:center"><c:out value="${jeu.plateforme}"></c:out></td>
							<td style="text-align:center"><c:out value="${jeu.anneeSortie}"></c:out></td>
							<td style="text-align:center"><button type="button" class="btn btn-warning" style="color:white;width:100px;"><a  style="color:white" href="/ExerciceServlets/JeuServlet/<c:out value='${jeu.id}'></c:out>">Editer</a></button></td>
							<td style="text-align:center"><button type="button" class="btn btn-primary" style="color:white;width:100px;"><a  style="color:white" href="/ExerciceServlets/PlateformeServlet/<c:out value='${jeu.plateforme}'></c:out>">Trier <c:out value='${jeu.plateforme}'></c:out></a></button></td>
							<td style="text-align:center">
								<!-- form action method precise ou allez chercher l'information -->
									<form action="/ExerciceServlets/SupprimeServlet" method="post">
											<input type="hidden" name="suprId" value="<c:out value='${jeu.id}'></c:out>"/>
											<input type="submit" class="btn btn-danger" value="Supprimer"/>
								</form>
						</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row">
			<div class="col-md-4">
			<button type="button" class="btn btn-primary"><a href="/ExerciceServlets/JeuServlet/0" style="text-decoration:none;color:white;font-weight:bold">Creer un nouveau jeu</a></button>
			</div>
			<br>
			<br>
			<div class="col-md-4">
				
			</div>
			</div>
		</div>
	</div>

	
</body>

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>