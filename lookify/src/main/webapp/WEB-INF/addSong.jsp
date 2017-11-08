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
	<form:form method="POST" action="/songs/new" modelAttribute="song">
		<p> 
	    <form:label path="name">Title
	    <form:input path="name"/></form:label>
	    </p>
	     
	    <p>
	    <form:label path="artist">Artist
	    <form:input path="artist"/></form:label>
	    </p>
	    
	    <p>
	    <form:label path="rating">Rating
	    <form:input type="number" path="rating" min="1" max="10"/></form:label>
		</p>
		
	    <input type="submit" value="Add Song"/>
	</form:form>
</body>
</html>