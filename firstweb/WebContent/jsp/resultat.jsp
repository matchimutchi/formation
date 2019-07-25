<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
<link  rel="stylesheet" type="text/css" href="http://localhost:8080/firstweb/css/style.css"/>
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
		<div class="col-md-2 offset-md-1">
		<h3>Resultat</h3>
			<p class="resultat"> Le résultat du calcul est <%= request.getAttribute("resultat") %>
		</div>
	</div>


</body>

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>