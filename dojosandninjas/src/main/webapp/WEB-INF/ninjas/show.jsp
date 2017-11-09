<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<h1>${dojo.name} Location Ninjas</h1>
	<table class="table">
	
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	<c:forEach items="${ninjas}" var="ninja" varStatus="loop">
	    <tr>    
	    	<td><c:out value="${ninja.firstName}"/></td>
	    	<td><c:out value="${ninja.lastName}"/></td>
	    	<td><c:out value="${ninja.age}"/></td>
	    </tr>
	</c:forEach>
	</table>
</body>
</html>

