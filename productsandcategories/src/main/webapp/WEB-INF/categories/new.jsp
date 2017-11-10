<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>New Category</h1>
		<p>
			<form:form method="POST" action="/categories/new" modelAttribute="category">
				<p> 
				    <form:label path="name">Name:
				    <form:input  class="form-control" path="name"/></form:label>
			    </p>
			    			    
			    <input class="btn btn-default" type="submit" value="Create"/>
			</form:form>
		</p>
	
	</div>
</body>
</html>
 