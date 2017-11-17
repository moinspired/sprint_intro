<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>

	<div class="top_section">
		<form id="logoutForm" method="POST" action="/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit" value="Logout!" />
		</form>

		<h1>
			Welcome,
			<c:out value="${currentUser.firstName} ${currentUser.lastName}"></c:out>
		</h1>

		<p>Welcome to your awsome magical ring finder, put the ring on,
			only good things will happen, Maybe it'll make you live forever, go
			invisible, turn your inherent hunger for riches or power into an
			insatiable curse that eventually dooms your entire species.</p>

	</div>
	<!-- closing top -->
	<div class="middle_section">

		<div class="middle_left">
			<p>Rings of Power</p>

			<form class="form col-sm-6" action="/bind" method="POST">
				<select name="ring_id">>
					<c:forEach var="ring" items="${rings}">
						<c:if test="${ring.user == null}">
						<option value="${ring.id}"><c:out value="${ring.value}" /></option>
						</c:if>
					</c:forEach>
				</select> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" value="BIND YOURSELF IN DARKNESS" />
			</form>
		</div>
		
		<div class="middle_right">
			<c:forEach var="role" items="${currentUser.roles}">
				<c:if test="${role.name.equals('ROLE_ADMIN')}">
					<p>
						<a href="/ring_creater">Ring Creator (Powerful Ainur only</a>
					</p>
					<p>
						<a href="/fool_creator">Person/Team Creator
							(Powerful Ainur only)</a>
					</p>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div>
		<table border=1>
			<tr>
				<th>Rings you have found</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="ring" items="${currentUser.rings}">
			<tr>
				<td><c:out value="${ring.value}"/></td>
				<td><a href="/delete/ring/${ring.id}">Lose the Ring (Delete)</a></td>
			</tr>
			</c:forEach>
		
	</div>
</body>
</html>