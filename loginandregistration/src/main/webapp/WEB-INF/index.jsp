<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
	<h1>Login</h1>
	<form action="/login" method="post">
		<div col-xs-3 >
			<label  for="username">Email:</label> 
			<input type="text" class=" form-control">
		</div>
		<div class="form-group">
			<label for="password">Password:</label>
			<input type="text" name="password" class="form-control">
		</div>
		<div class="form-group">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Login" class="btn btn-default">
		</div>
	</form>

	  <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="username">Email:</form:label>
            <form:input class=" form-control" path="username"/>
        </p>
         <p>
            <form:label path="firstname">First Name:</form:label>
            <form:input class=" form-control" path="firstname"/>
        </p>
          <p>
            <form:label path="lastname">Last Name:</form:label>
            <form:input  class=" form-control" path="lastname"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password  class=" form-control" path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class=" form-control" path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register" class="btn btn-default">
    </form:form>
	</div>
</body>
</html>