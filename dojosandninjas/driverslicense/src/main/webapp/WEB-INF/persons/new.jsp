<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<body>
	<div class="Container">
		<h1>New Person</h1>
		<p>
			<form:form method="POST" action="/person/new" modelAttribute="person">
				<p> 
			    <form:label path="firstName">First Name:
			    <form:input path="firstName"/></form:label>
			    </p>
			     
			    <p>
			    <form:label path="lastName">Last Name:
			    <form:input path="lastName"/></form:label>
			    </p>
			    
			    <input type="submit" value="Create"/>
			</form:form>
		</p>
	
	</div>
</body>
</html>
 