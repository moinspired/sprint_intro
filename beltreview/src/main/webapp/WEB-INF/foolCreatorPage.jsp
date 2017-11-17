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
	<div class="top_section">
		<h1>Welcome Iluvatar!"</h1>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Teams</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.team != NULL}">
				<tr>
					<td>${user.firstName}  ${user.lastName}</td>
					<td><a href="/team/${user.team.id}">${user.team.name}</a></td>
					<td>50</td>
					<td>
						<a href="delete/user/${user.id}}">Destroy</a> 
						<c:forEach var="role" items="${user.roles}">
							<c:if test="${role.id == 1}">
								<a href="/make/admin/${user.id}">Make user admin</a>
							</c:if>
						</c:forEach>
					</td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<div class="middle_section">

		<form class="form col-sm-6" action="/join/team" method="POST">
			<select name="user_id">
				<c:forEach var="user" items="${users}">
					<c:if test="${user.team == NULL}">
					<option value="${user.id}"><c:out value="${user.firstName} ${user.lastName}" /></option>
					</c:if>
				</c:forEach>
			</select> 
		
			<select name="team_id">>
				<c:forEach var="team" items="${teams}">
					<option value="${team.id}"><c:out value="${team.name}" /></option>
				</c:forEach>
			</select> <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit" value="Join" />
		</form>

		<form action="create/team" method="POST">
			Team Name: <input type="text" name="teamName" /> Team Size: <input
				type="text" name="size" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
				type="submit" value="Create" />
		</form>

	</div>
</body>
</html>