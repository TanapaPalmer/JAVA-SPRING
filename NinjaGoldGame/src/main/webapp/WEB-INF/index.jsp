<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NINJA GOLD GAME</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-center col-18">
	    <div class="p-5">
	    <h2 class="text-primary">YOUR GOLD: <c:out value="${gold}"></c:out></h2>
			<table class="my-5">
				<tbody>
					<tr>
						<td>
							<form action="/" method="post" class="card mx-auto p-4 shadow border border-primary border-4 rounded rounded-3 text-center">
								<h3 class="text-primary">Farm</h3>
								<p>(earns 10-20 gold)</p>
								<input class="btn btn-primary text-light text-center" type="submit" value="Find Gold!" name="farm" >
							</form>	
						</td>
						<td>			
							<form action="/" method="post" class="card mx-auto p-4 shadow border border-primary border-4 rounded rounded-3 text-center">
								<h3 class="text-primary">Cave</h3>
								<p>(earns 5-10 gold)</p>
								<input class="btn btn-primary text-light text-center" type="submit" value="Find Gold!" name="cave">
							</form>
						</td>
						<td>
							<form action="/" method="post" class="card mx-auto p-4 shadow border border-primary border-4 rounded rounded-3 text-center">
								<h3 class="text-primary">House</h3>
								<p>(earns 2-5 gold)</p>
								<input class="btn btn-primary text-light text-center" type="submit" value="Find Gold!" name="house">
							</form>
						</td>
						<td>
							<form action="/" method="post" class="card mx-auto p-4 shadow border border-primary border-4 rounded rounded-3 text-center">
								<h3 class="text-primary">Quest</h3>
								<p>(earns/takes 0-50 gold)</p>
								<input class="btn btn-primary text-light text-center" type="submit" value="Find Gold!" name="quest">
							</form>
						</td>
					</tr>
				</tbody>
			</table>
			
	    <h2 class="text-primary">ACTIVITIES:</h2>
		<iframe src="/activities" title="Activities Iframe" class="form-control my-5 card mx-auto p-4 shadow border border-primary border-4 rounded rounded-3"></iframe>
		</div>
	</div>
</body>
</html>