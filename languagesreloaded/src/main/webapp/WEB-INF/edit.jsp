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
 	
 	<form:form metho="POST" action="/languages/update/${id}" modelAttribute="language">
 		<p>
	 		<form:label path="name">Title
	 		<form:errors path="name"/>
	 		<form:input path="name"/></form:label>
 		</p>
 		<p>
	 		<form:label path="creator">Creator
	 		<form:errors path="creator"/>
	 		<form:input path="creator"/></form:label>
 		</p>
 		<p>
	 		<form:label path="version">Creator
	 		<form:errors path="version"/>
	 		<form:input path="version"/></form:label>
 		</p>
 		
 		<p>
	 		<input type="submit" value="Update">
 		</p>
 	</form:form>
</body>
</html>