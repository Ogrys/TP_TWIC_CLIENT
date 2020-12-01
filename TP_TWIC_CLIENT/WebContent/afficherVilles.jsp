<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
	<%@ page import="com.Ville"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<nav aria-label="Page navigation example">
		<a href=ChoixVilles.jsp>Revenir à l'accueil</a><br><br>
		<ul class="pagination">
			<li class="page-item"><a class="page-link"
				href="AfficherVilles?page=
				<%Integer pages = (Integer) request.getAttribute("numPage");
				if (pages <= 1) {
					pages = 2;
				}%>
				<%=pages - 1%>">Previous</a></li>
			<li class="page-item"><a class="page-link" href="AfficherVilles?page=
				<%Integer pagesS = (Integer) request.getAttribute("numPage");%>
				<%=pagesS + 1%>">Next</a></li>
		</ul>
	</nav>
		<div class="card border-0 shadow my-5">
			<div class="card-body p-5">
				<h1 class="font-weight-light">Liste des villes :</h1>
				<br>
				<div style="height: 2500px">
					<%
					@SuppressWarnings("unchecked")
					ArrayList<Ville> liste2 = (ArrayList<Ville>) request.getAttribute("villesPage");
					for (Ville ville : liste2) {
					%>
					<%=ville.getNomCommune()%>
					<a href="ModifierVille?ville=<%=ville.getNomCommune()%>">Modifier</a>
					<a href="SupprimerVille?ville=<%=ville.getNomCommune()%>">Supprimer</a><br>
					<br>
					<%
						}
					%>

				</div>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</html>