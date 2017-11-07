<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<table class="table">
<c:forEach items="${languages}" var="language" varStatus="loop">
    <tr>    
    	<td><c:out value="${language.name}"/></td>
    	<td><c:out value="${language.creator}"/></td>
    	<td><c:out value="${language.version}"/></td>
    	<td><a href="/languages/delete/${loop.index}">Delete</a></td>
    	<td><a href="/languages/edit/${loop.index}">Edit</a></td>
    </tr>
</c:forEach>
</table>

<form action="/languages/edit/" method="POST">
		<label>Name:</label>
		<input type="text" name="name"/>
		
		<label>Creator:</label>
		<input type="text" name="creator"/>
		
		<label>Version:</label>
		<input type="text" name="version"/>
	
		<input type="submit" value="Submit"/>
	</form>