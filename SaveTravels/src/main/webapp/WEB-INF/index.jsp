<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SAVE TRAVELS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
		<h2 class="text-warning text-center p-3">SAVE TRAVELS</h2>
			<table class="table table-striped border border-warning border-3 text-center">
				<tr>
					<th scope="col">EXPENSE</th>
					<th scope="col">VENDOR</th>
					<th scope="col">AMOUNT</th>
					<th scope="col">ACTION</th>
					<th></th>
				</tr>
				<c:forEach var="expense" items="${expenses}">
				<tr>
					<td scope="row"><a href="expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
					<td class="col-4"><c:out value="${expense.vendor}"/></td>
					<td>$<fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}"/></td>
					<td><a href="expenses/edit/${expense.id}">EDIT</a></td>
					<td><a href="expenses/delete/${expense.id}" class="btn btn-danger text-light text-center">DELETE</a></td>
				</tr>
				</c:forEach>
			</table>
		<h3 class="text-warning text-center p-3">ADD AN EXPENSE:</h3>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/expenses/new" mode="post" modelAttribute="expense"  class="card col-5 p-4 mx-auto bg-default shadow border border-warning border-4 rounded rounded-3">
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