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
    <title>SHOW NINJAS ON EACH DOJO LOCATIONS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-5">
		<h2 class="text-primary text-center p-3 text-uppercase"><c:out value="${dojo.name} "/>LOCATION NINJAS</h2>
			<table class="table table-striped border border-primary border-4 text-center">
				<tr>
					<th scope="col">FIRST NAME</th>
					<th scope="col">LAST NAME</th>
					<th scope="col">AGE</th>
				</tr>
				<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td scope="row"><c:out value="${ninja.firstName}"/></td>
					<td class="col-4"><c:out value="${ninja.lastName}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>