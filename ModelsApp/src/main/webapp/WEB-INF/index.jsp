<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<c:forEach items="${errs}" var="error">
			<p>${error.defaultMessage}</p>
		</c:forEach>

		<c:forEach items="${users}" var="user">
			<p>${user.firstName}</p>
			<p>${user.age}</p>
		</c:forEach>

		<form:form action="/users/new" method="post" modelAttribute="user">
			<form:label path="firstName">First Name:
				<form:errors path="firstName"></form:errors>
				<form:input type="text" path="firstName"></form:input>
			</form:label>

			<form:label path="age">Age:
				<form:errors path="age"></form:errors>
				<form:input type="number" path="age"></form:input>
			</form:label>

			<input type="submit" value="Create User" />
		</form:form>
	</body>
</html>