<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOME</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex justify-content-center row">
		<div class="my-5 text-center">
			<h1 class="text-primary">Welcome User!</h1>
			<h4>Let see how many times you have visited this page.</h4>
			<p><a href="/counter">Let's go!</a></p>
			<hr>
			<p><a href="/countbytwo">NINJA BONUS</a></p>
		</div>
	</div>
</body>
</html>