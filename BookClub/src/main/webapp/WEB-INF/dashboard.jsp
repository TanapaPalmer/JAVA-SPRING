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
    <title>SHOW THE BOOKS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-around col-6 my-5">
        <div class="row justify-content-around">
            <h2 class="col-6 text-warning my-4">WELCOME, <c:out value="${user.userName}"/></h2>
            <a href="/logout" class="offset-3 col-3 my-4">LOGOUT</a>
        </div>
        <div class="row justify-content-around">      
            <p>BOOKS FROM EVERYONE'S SHELVES:
            <a href="/books/new" class="offset-3 col-5 my-3">+ ADD A BOOK TO MY SHELF!</a>
        </div>
		<div class="border border-warning border-4 rounded rounded-3 p-3 bg-basic my-5">
			<table class="table table-striped text-center">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">TITLE</th>
					<th scope="col">AUTHOR NAME</th>
					<th scope="col">POSTED BY</th>
				</tr>
				<c:forEach var="book" items="${books}">
				<tr>
					<td scope="row"><c:out value="${book.id}"/></td>
					<td class="col-4"><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>