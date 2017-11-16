<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <h1>Welcome Page <c:out value="${currentUser.firstName}"></c:out></h1>
  	
  	  <div>
    	<p>First Name <c:out value="${currentUser.firstName}"></c:out></p>
    	<p>Last Name <c:out value="${currentUser.lastName}"></c:out></p>
    	<p>Email <c:out value="${currentUser.username}"></c:out></p>
    	<p>Sign up date <c:out value="${currentUser.createdAt}"></c:out></p>
    	<p>Last Sign in <c:out value="${currentUser.updatedAt}"></c:out></p>
    </div>
    
</body>
</html>