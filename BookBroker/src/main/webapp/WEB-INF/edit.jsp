<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDIT BOOK</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
		<div class="d-flex justify-content-around col-12">
			<h1 class="my-4">CHANGE YOUR ENTRY</h1>
			<p class="my-5"><a href="/bookmarket">BACK TO THE SHELVES</a></p>
		</div>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/books/${book.id}/update" mode="put" modelAttribute="book"  class="card col-8 p-4 mx-auto bg-dark shadow border border-light border-4 rounded rounded-3 text-light">
				<form:label path="title" class="form-label my-3"><strong>TITLE</strong></form:label>
				<form:errors path="title" class="text-danger"/>
		        <form:input path="title" class="form-control"/>
		        <form:label path="author" class="form-label my-3"><strong>AUTHOR</strong></form:label>
				<form:errors path="author" class="text-danger"/>
		        <form:input path="author" class="form-control"/>
		        <form:label path="thoughts" class="form-label my-3"><strong>MY THOUGHTS</strong></form:label>
		       	<form:errors path="thoughts" class="text-danger"/>
		        <form:textarea path="thoughts" class="form-control"></form:textarea><br>
		        <input type="submit" value="Submit" class="btn btn-light text-dark text-center"/>

				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>

				<hr>
				<a class="btn btn-danger text-center col-4" href="/books/${book.id}/delete" role="button">DELETE</a>
			</form:form>
		</div>
	</div>
</body>
</html>
