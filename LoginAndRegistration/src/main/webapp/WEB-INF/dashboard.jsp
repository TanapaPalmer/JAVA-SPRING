<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DASHBOARD</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-cnter col-6 my-5">
		<div class="p-4 mx-auto shadow border border-light bg-success border-4 rounded rounded-3 text-light">
			<h1 class="text-uppercase"><strong>WELCOME, </strong><c:out value="${user.userName}"/>!</h1>
			<p class="my-5"><strong>THIS IS YOUR DASHBOARD. NOTHING TO SEE HERE YET!</strong></p>
			<p><a href="/logout">LOGOUT</a></p>
		</div>
	</div>
</body>
</html>