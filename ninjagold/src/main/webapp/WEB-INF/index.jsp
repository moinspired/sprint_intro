<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Title</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Your Gold: ${GoldVal}</h1>
		</div>
		<div class="row">
			<div class="col">
				<form class="col-sm" action="/process" method="post">
					<h2>Farm</h2>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="building" value="farm" /> <input
						class="btn btn-default" type="submit" value="Find Gold!" />
				</form>
			</div>


			<div class="col">
				<form class="col-sm" action="/process" method="post">
					<h2>Cave</h2>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="building" value="cave" /> <input
						class="btn btn-default" type="submit" value="Find Gold!" />
				</form>
			</div>


			<div class="col">
				<form action="/process" method="post">
					<h2>House</h2>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="building" value="house" /> <input
						class="btn btn-default" type="submit" value="Find Gold!" />
				</form>
			</div>

			<div class="col">
				<form action="/process" method="post">
					<h2>Casino</h2>
					<p>(earns/gain 0-50 gold)</p>
					<input type="hidden" name="building" value="casino" /> <input
						class="btn btn-default" type="submit" value="Find Gold!" />
				</form>
			</div>

		</div class="col">
		<!--end of row -->
		
		<di class="form-group">
			<h3>Activities:</h3>
		</di>
	
		<div class="form-group">
			<textarea class="form-control" rows="5" id="comment">
				<c:forEach var="msg" items="${messages}">
						${msg}
				</c:forEach>
			</textarea>
		</div>
</body>
</html>