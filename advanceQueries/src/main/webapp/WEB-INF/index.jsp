<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>
	<h1>Dojos and Ninjas</h1>
	<table class="table">
		<thead>
			<th>Dojo Name</th>
			<th>Ninja First Name</th>
			<th>Ninja Last Name</th>
		</thead>
		<tbody>
			<c:forEach var="row" items="${table}">
				<tr>
					<td>${row[0].name}</td>
					<td>${row[1].firstName}</td>
					<td>${row[1].lastName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

