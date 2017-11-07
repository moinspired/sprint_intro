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
	<header>
		<a href="/">Dashboard</a>
	</header>
	<c:out value="${language.name}"/></p>
	<c:out value="${language.creator}"/></p>
	<c:out value="${language.version}"/></p>
	
	<div>
	<a href="/language/edit/${language.id }">Edit</a>
	<a href="/languages/delete${language.id}">Delete</a>
	</div>
</body>
</html>