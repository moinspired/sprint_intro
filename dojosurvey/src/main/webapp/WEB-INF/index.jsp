<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dojo Survey Index</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<form action="/result" method="POST">
		<p>
			<label>Your Name:</label>
			<input type="text" name="name"/>
		</p>
		<p>
			<label>Dojo Location</label>
			<select name="location">
				<option value="Burbank">Burbank</option>
				<option value="San Jose">San Jose</option>
				<option value="Seattle">Seattle</option>
			</select>
		</p>
		<p>
			<label>Language</label>
			<select name="language">
				<option value="Java">Java</option>
				<option value="Python">Python</option>
				<option value="Ruby">Ruby</option>
				<option value="JavaScript">JavaScript</option>
			</select>
		</p>		
		<p>
			<label for="comment">Comment (optional)</label>
			<textarea name="comment" id="" cols="60" rows="10"></textarea>
		</p>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>