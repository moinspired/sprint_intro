<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search</title>
</head>
<body>
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