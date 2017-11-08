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
		<h1>New License</h1>
		<p>
			<form:form method="POST" action="/license/new" modelAttribute="license">
				<p>
					<form:label path="person">Person:</form:label>
					<form:select path="person">
						<c:forEach items="${persons}" var="person">
							<form:option value="${person}" label="${person.firstName}  ${person.lastName}" />
						</c:forEach>
					</form:select>
				</p>
			    <p>
			    <form:label path="state">State:
			    <form:input path="state"/></form:label>
			    </p>
			    
			    <p>
			    <form:label path="expiration_date">Expiration Date:
			    <form:input type="date" path="expiration_date"/></form:label>
			    </p>
			    
			    <input type="submit" value="Create"/>
			</form:form>
		</p>
	
	</div>
</body>
</html>