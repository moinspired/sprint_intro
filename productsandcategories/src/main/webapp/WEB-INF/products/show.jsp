<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<h1>${product.name}</h1>

		<h3>Categories:</h3>
		<ul class="list-group col-sm-6">
			<c:forEach items="${product_categories}" var="category" varStatus="loop">
				<li class="list-group-item">${category.name}</li>
			</c:forEach>
		</ul>

		<form class="form col-sm-6" action="/products/${product.id}/addCategory" method="POST">
			<label>Add Product:</label>
			<select class="form-control" name="category_id">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}" label="${category.name}" />
			</c:forEach>
			</select> 
			<input class="btn btn-default" type="submit" value="Create" />
		</form>

	</div>
</body>
</html>
