<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		
	
			<form:form action="/languages/edit/${index}" method="POST" modelAttribute="language">
				<p>
					<form:label path="name" for="name">Name</form:label>
					<form:input path="name" class="input-size float" type="text" name="name"/>
				</p>
				<p>
					<form:label path="creator" for="creator">Creator</form:label>
					<form:input path="creator" class="input-size float" type="text" name="creator"/>
				</p>
				<p>
					<form:label path="version" for="version">Version</form:label>
					<form:input path="version" class="input-size float" type="text" name="version"/>
				</p>
				<input class="float" type="submit" value="Update" />						
			</form:form>
