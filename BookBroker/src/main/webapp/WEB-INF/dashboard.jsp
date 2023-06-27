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
	<div class="container justify-content-around col-7 my-5">
        <div class="row justify-content-around">      
            <p>HELLO, <c:out value="${user.userName}"/>. WELCOME TO..
            <a href="/bookmarket" class="offset-6 col-6 my-3">BACK TO THE SHELVES</a></p>
        </div>
        <div>
        	<h1>THE BOOK BROKER!</h1>
        </div>
        <hr>
        <p class="col-6 my-4">AVAILABLE BOOKS TO BORROW </p>
        <div class="row justify-content-around">  
	        <a href="/newbook" class="btn btn-dark text-light text-center col-3">+ ADD A BOOK</a>
	        <a href="/logout" class="btn btn-dark text-light text-center col-3">LOGOUT</a>
        </div>
		<div class="border border-dark border-4 rounded rounded-3 p-3 bg-default my-5">
			<table class="table table-striped text-center">
				<thead class="bg-dark text-light">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">TITLE</th>
						<th scope="col">AUTHOR NAME</th>
						<th scope="col">OWNER</th>
						<th scope="col">ACTIONS</th>
					</tr>
				</thead>
				<c:forEach var="book" items="${books}">
				<c:if test="${user.id!=book.borrower.id}">
				<tr>
					<td scope="row"><c:out value="${book.id}"/></td>
					<td class="col-4"><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
					<td>
					<c:if test="${user==book.user}">
						<a class="btn btn-dark text-light text-center" href="/books/${book.id}/edit" role="button">EDIT</a>
						<a class="btn btn-dark text-light text-center" href="/books/${book.id}/delete" role="button">DELETE</a>
					</c:if>
					<c:if test="${user!=book.user}">
						<a class="btn btn-dark text-light text-center" href="/books/${book.id}/borrow" role="button">BORROW</a>
					</c:if>
					</td>
				</tr>
				</c:if>
				</c:forEach>
			</table>
		</div>
        <hr>
        <p class="col-6 my-4">BOOKS I'M BORROWING</p>
		<div class="border border-dark border-4 rounded rounded-3 p-3 bg-default my-5">
			<table class="table table-striped text-center">
				<thead class="bg-dark text-light">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">TITLE</th>
						<th scope="col">AUTHOR NAME</th>
						<th scope="col">OWNER</th>
						<th scope="col">ACTIONS</th>
					</tr>
				</thead>
				<c:forEach var="book" items="${books}">
				<c:if test="${user.id==book.borrower.id}">
				<tr>
					<td scope="row"><c:out value="${book.id}"/></td>
					<td class="col-4"><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
					<c:if test="${user!=book.user}">
					<td><a class="btn btn-dark text-light text-center" href="/books/${book.id}/return" role="button">RETURN</a></td>
					</c:if>
				</tr>
				</c:if>
				</c:forEach>
			</table>
		</div>		
	</div>
</body>
</html>

