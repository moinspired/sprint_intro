<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
	    <h1>Your gold: ${gold} </span></h1>
	  	<form action="/process" method="post">
	  		<h3>Farm</h3>
	        <p>(earns 10-20 gold)</p>
	   		<input type="submit" name="farm" value="Find Gold!"/>
	    </form>
	   	<form action="/process" method="post">
	  		<h3>Cave</h3>
	        <p>(earns 5-10 gold)</p>
	   		<input type="submit" name="cave" value="Find Gold!"/>
	    </form>
	    <form action="/process" method="post">
	  		<h3>House</h3>
	        <p>(earns 3-5 gold)</p>
	   		<input type="submit" name="house" value="Find Gold!"/>
	    </form>
	     <form action="/process" method="post">
	  		<h3>Casino</h3>
	        <p>(earns 3-5 gold)</p>
	   		<input type="submit" name="casino" value="Find Gold!"/>
	    </form>
	    <h1>Activities</h1>
	    <div class="Activities">
	    	<c:forEach items = "${activities}" var = "activity">
	    		<p>${activity}</p>
	    	</c:forEach>
	    </div>
</body>
</html>