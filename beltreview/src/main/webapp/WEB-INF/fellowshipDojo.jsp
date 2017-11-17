<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<a href="/home">back</a>
	<div class="top_section">
		<h1>${team.name}</h1>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${users}">
			<c:if test="${user.team.id== team.id}">
			<tr>
				<td>${user.firstName}</td>
				<td>Age</td>
				<td>
					<a href="#">Destroy</a>
					<a href="#">Update</a>
				</td>
			</tr>
			</c:if>
			</c:forEach>
		</table>
	</div>
</body>
</html>