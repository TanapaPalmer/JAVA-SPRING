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
    <title>EDIT EXPENSE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
		<h3 class="text-warning text-center p-3">EDIT EXPENSE</h3>
		<div class="d-flex justify-content-end col-8">
			<p><a href="/expenses">GO BACK</a></p>
		</div>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/expenses/update/${expense.id}" mode="put" modelAttribute="expense"  class="card col-5 p-4 mx-auto bg-default shadow border border-warning border-4 rounded rounded-3">
				<form:label path="name" class="form-label"><strong>EXPENSE NAME:</strong></form:label>
				<form:errors path="name" class="text-danger"/>
		        <form:input path="name" class="form-control"/>
		        <form:label path="vendor" class="form-label"><strong>VENDOR:</strong></form:label>
				<form:errors path="vendor" class="text-danger"/>
		        <form:input path="vendor" class="form-control"/>
		        <form:label path="amount" class="form-label"><strong>AMOUNT:</strong></form:label>
				<form:errors path="amount" class="text-danger"/>
		        <form:input type="number" step="0.01" min="1" path="amount" class="form-label"/>
		        <form:label path="description" class="form-label"><strong>DESCRIPTION:</strong></form:label>
		       	<form:errors path="description" class="text-danger"/>
		        <form:textarea path="description" class="form-control"></form:textarea><br>
		        <input type="submit" value="Submit" class="btn btn-warning text-light text-center"/>
			</form:form>
		</div>
	</div>
</body>
</html>