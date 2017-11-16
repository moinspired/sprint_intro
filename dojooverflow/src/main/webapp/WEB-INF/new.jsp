<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Question</title>
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1>What is your question?</h1>

		<form action="/questions/new" method="POST" modelAttribute="questionModel">
			<p>
				<label for="question">Question:</label> 
				<input type="text" name="question" />
			</p>
			<p>
				<lable for="tags">Tags:</label> 
				<input type="text" required="required" name="tags" />
			</p>
			<input type="submit" value="Create" />
		</form>
	</div>
</body>
</html>