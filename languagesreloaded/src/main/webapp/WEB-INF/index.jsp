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
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="lang" items="${languages}">
				<tr>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
					<td><c:out value="${lang.creator}"/></td>
					<td><c:out value="${lang.version}"/></td>
					<td>
						<a href="/languages/edit/${lang.id }">Edit</a>
						<a href="/languages/delete/${lang.id }">Delete</a>
					</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>

		<div class="form-container">
			<form:form action="/languages" method="POST" modelAttribute="language">
				<p>
					<form:label path="name" for="name">Name</form:label>
					<form:input path="name" class="input-size float" type="text" name="name"/>
				</p>
				<p>
					<form:label path="creator" for="creator">Creator</form:label>
					<form:input path="creator" class="input-size float" type="text" name="creator"/>
				</p>
				<p>
					<form:label path="version" for="version">Version</form:label>
					<form:input path="version" class="input-size float" type="text" name="version"/>
				</p>
				<input class="float" type="submit" value="Submit" />						
			</form:form>
		</div>

		
	</div>
</body>
</html>