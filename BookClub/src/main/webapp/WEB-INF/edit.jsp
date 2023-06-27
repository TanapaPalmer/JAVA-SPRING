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
			<h1 class="text-warning my-4">CHANGE YOUR ENTRY</h1>
			<p class="my-5"><a href="/books">BACK TO THE SHELVES</a></p>
		</div>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/books/${book.id}/update" mode="put" modelAttribute="book"  class="card col-8 p-4 mx-auto bg-dark shadow border border-warning border-4 rounded rounded-3 text-warning">
				<form:label path="title" class="form-label"><strong>TITLE</strong></form:label>
				<form:errors path="title" class="text-danger"/>
		        <form:input path="title" class="form-control"/>
		        <form:label path="author" class="form-label"><strong>AUTHOR</strong></form:label>
				<form:errors path="author" class="text-danger"/>
		        <form:input path="author" class="form-control"/>
		        <form:label path="thoughts" class="form-label"><strong>MY THOUGHTS</strong></form:label>
		       	<form:errors path="thoughts" class="text-danger"/>
		        <form:textarea path="thoughts" class="form-control"></form:textarea><br>
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
		        <input type="submit" value="Submit" class="btn btn-warning text-dark text-center"/>
			</form:form>
		</div>
	</div>
</body>
</html>