<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>COUNTER</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-center row">
		<div class="my-5 text-center">
			<h4>You have visited <c:out value="${count}"></c:out> times.</h4>
			<p><a href="/">Test another visit?</a></p>
			<hr>
			<p><a href="/reset" class="btn btn-primary text-light text-center my-3">RESET</a></p>
			<hr>
			<p><a href="/countbytwo">NINJA BONUS</a></p>
		</div>
	</div>
</body>
</html>