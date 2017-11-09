<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
	<div class="Container">
		<h1>New Ninja</h1>
		<p>
			<form:form method="POST" action="/ninja/new" modelAttribute="ninja">
				<p>
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo">
						<c:forEach items="${dojos}" var="dojo">
							<form:option value="${dojo}" label="${dojo.name}" />
						</c:forEach>
					</form:select>
				</p>
			   
			    <p>
			    <form:label path="firstName">Fist Name:
			    <form:input path="firstName"/></form:label>
			    </p>
			    
			    <p>
			    <form:label path="lastName">Last Name:
			    <form:input path="lastName"/></form:label>
			    </p>
			    
			    <p>
			    <form:label path="age">Age:
			    <form:input path="age"/></form:label>
			    </p>
			    
			    <input type="submit" value="Create"/>
			</form:form>
		</p>
	
	</div>
</body>
</html>