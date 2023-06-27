<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ADD SONG</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
   		<div class="d-flex justify-content-around col-12"> 
			<h1 class=" my-4">ADD SONG!</h1>
		</div>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/songs/new" mode="post" modelAttribute="song" class="card col-8 p-4 mx-auto bg-dark shadow border border-light border-4 rounded rounded-3 text-light">
				<form:label path="title" class="form-label my-3"><strong>TITLE:</strong></form:label>
				<form:errors path="title" class="text-danger"/>
		        <form:input path="title" class="form-control"/>
		        <form:label path="artist" class="form-label my-3"><strong>ARTIST:</strong></form:label>
				<form:errors path="artist" class="text-danger"/>
		        <form:input path="artist" class="form-control"/>
		        <form:label path="rating" class="form-label my-3"><strong>RATING (1-10):</strong></form:label>
		       	<form:errors path="rating" class="text-danger"/>
		        <form:input path="rating" class="form-control" type="number"/><br>
		        <c:forEach var="song" items="${songs}">
			        <form:errors path="song" class="error"/>
					<form:input type="hidden" path="song" value="${song.id}" class="form-control"/>
				</c:forEach>
				<hr>
			    <input type="submit" value="ADD" class="btn btn-light text-center align-self-end col-2"/>
			</form:form>
			</div>
			<div class="container justify-content-around col-8 my-3">
			    <a class="btn btn-warning text-light text-center col-4" href="/dashboard" role="button">DASHBOARD</a>
			</div>
	</div>
</body>
</html>




