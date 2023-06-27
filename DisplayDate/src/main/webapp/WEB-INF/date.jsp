<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Date</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="d-flex justify-content-center my-5">
		<div class="border border-primary border-4 rounded rounded-3 p-5 col-5">
			<div class="d-flex justify-content-center">
				<h1 class="text-primary"><c:out value="${date}"/></h1>
			</div>
		</div>
	</div>
</body>
</html>