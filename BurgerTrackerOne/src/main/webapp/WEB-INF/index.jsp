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
    <title>BURGER TRACKER ONE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
		<h2 class="text-success text-center p-3">BURGER TRACKER</h2>
			<table class="table table-striped border border-success border-3 text-center">
				<tr>
					<th scope="col">BURGER NAME</th>
					<th scope="col">RESTAURANT NAME</th>
					<th scope="col">RATING (OUT OF 5)</th>
					<th scope="col">ACTION</th>
				</tr>
				<c:forEach var="burger" items="${burgers}">
				<tr>
					<td scope="row"><c:out value="${burger.burger_name}"/></td>
					<td class="col-4"><c:out value="${burger.restaurant_name}"/></td>
					<td><c:out value="${burger.rating}"/></td>
					<td><a href="edit/${burger.id}">EDIT</a></td>
				</tr>
				</c:forEach>
			</table>
		<h3 class="text-success text-center p-3">ADD A BURGER</h3>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/burgers/new" mode="post" modelAttribute="burger"  class="card col-5 p-4 mx-auto bg-default shadow border border-success border-4 rounded rounded-3">
				<form:label path="burger_name" class="form-label"><strong>BURGER NAME:</strong></form:label>
				<form:errors path="burger_name" class="text-danger"/>
		        <form:input path="burger_name" class="form-control"/>
		        <form:label path="restaurant_name" class="form-label"><strong>RESTAURANT NAME:</strong></form:label>
				<form:errors path="restaurant_name" class="text-danger"/>
		        <form:input path="restaurant_name" class="form-control"/>
		        <form:label path="rating" class="form-label"><strong>RATING:</strong></form:label>
				<form:errors path="rating" class="text-danger"/>
		        <form:input type="number" path="rating" class="form-label"/>
		        <form:label path="notes" class="form-label"><strong>NOTES:</strong></form:label>
		       	<form:errors path="notes" class="text-danger"/>
		        <form:textarea path="notes" class="form-control"></form:textarea><br>
		        <input type="submit" value="Submit" class="btn btn-success text-light text-center"/>
			</form:form>
		</div>
	</div>
</body>
</html>