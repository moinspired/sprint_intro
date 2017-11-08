<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Languages</title>
</head>
<body>
	<header><a href="/dashboard">Dashboard</a></header>
	<p>Title: ${song.name}</p>
	<p>Artist: ${song.artist}</p>
	<p>Rating (1-10) ${song.rating}</p>
	<p>
		<a href="/song/delete/${id}"></a>
	</p>
	<a href="/delete/${song.id}">Delete</a>
</body>
</html>