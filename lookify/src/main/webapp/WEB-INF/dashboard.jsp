<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Languages</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<form:form method="POST" action="/search" modelAttribute="song">
		<a href="/songs/new">Add New</a>
		<a href="#">Tag Songs</a>
		
		<form:label path="artist">
	    <form:input path="artist"/></form:label>

	     <input type="submit" value="Search Artists"/>
	</form:form>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td><a href="/song/${song.id}"><c:out value="${song.name}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td>
						<a href="/song/delete/${song.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>