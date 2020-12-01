<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Distance entre les villes</title>
</head>
<body style="background-color: silver;">
	<div>
		<div class="container">
			<div class="card border-0 shadow my-5">
				<div class="card-body p-5">
					<h1 class="font-weight-light">Résultat du calcul</h1>
					<p class="lead">
						La distance entre
						<%=session.getAttribute("ville1")%>
						et
						<%=session.getAttribute("ville2")%>
						est de
						<%=session.getAttribute("distance")%>
						km. <br><a href=ChoixVilles.jsp>Retour</a><br>
					</p>

				</div>
			</div>
		</div>
	</div>
</body>
</html>