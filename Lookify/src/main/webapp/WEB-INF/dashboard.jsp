<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DASHBOARD</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-center my-5 col-10">
        <div class="row justify-content-center">
        	<form action="dashboard" method="post">
				<a href="/songs/new" class="btn btn-primary text-light text-center col-2 offset-1">ADD NEW</a>
	        	<a href="/songs/top-ten" class="btn btn-success text-light text-center col-2 offset-1">TOP SONGS</a>
				<input id="artist" name="artist" placeholder="Search" class="offset-1"/>
				<input type="submit" value="SEARCH" class="btn btn-dark text-light text-center col-2"/>
			</form>
		</div>
		<div class="row justify-content-center">
			<div class="border border-dark border-4 rounded rounded-3 p-3 bg-default my-5 col-11">
				<table class="table table-striped text-center">
					<thead class="bg-dark text-light">
						<tr>
							<th scope="col">NAME</th>
							<th scope="col">RATING</th>
							<th scope="col">ACTIONS</th>
						</tr>
					</thead>
					<c:forEach var="song" items="${songs}">
					<tr>
						<td scope="row"><a href="songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td class="col-4"><c:out value="${song.rating}"/></td>
						<td><a href="songs/delete/${song.id}" class="btn btn-danger text-light text-center">DELETE</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>	
		</div>
	</div>
</body>
</html>