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
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout!" />
	</form>

	<h1>
		Welcome <c:out value="${currentUser.firstName}"></c:out>
	</h1>

	<table border=1>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>

		<c:forEach var="user" varStatus="loop" items="${users}">
				<tr>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><a href="/delete/user/${user.id}">delete</a> 
						<c:forEach var="role" varStatus="loop" items="${user.roles}">
							<c:choose>
							<c:when  test="${role.id == 1}">
								<a href="/add/user/admin/${user.id}">make-admin</a>
							</c:when>
							<c:otherwise>
								<span>admin</span>
							</c:otherwise>
							</c:choose>
						</c:forEach></td>
				</tr>
		</c:forEach>
	</table>

</body>
</html>