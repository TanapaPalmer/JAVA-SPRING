<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rendering Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center">
		<h1 class="text-success text-center p-3">ALL BOOKS</h1>
			<table class="table table-striped border border-success border-4 text-center">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Language</th>
					<th scope="col">Number of Pages</th>
				</tr>
				<c:forEach var="book" items="${books}">
				<tr>
					<td scope="row"><c:out value="${book.id}"/></td>
					<td class="col-4"><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.language}"/></td>
					<td><c:out value="${book.numberOfPages}"/></td>
				</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>
