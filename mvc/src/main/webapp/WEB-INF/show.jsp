<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show The Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-around col-6">
		<div class="border border-success border-4 rounded rounded-3 p-3">
			<div class="row mb-3 p-4">
				<h2><c:out value="${book.title}"/></h2>
				<hr>
				<p><strong>Description: </strong><c:out value="${book.description}"/></p>
				<p><strong>Language: </strong><c:out value="${book.language}"/></p>
				<p><strong>Number of Pages: </strong><c:out value="${book.numberOfPages}"/></p>
			</div>
		</div>
	</div>
</body>
</html>

