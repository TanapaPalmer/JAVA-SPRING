<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

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
	<div class="container justify-content-around col-8">
		<div class="d-flex justify-content-between col-16">
			<h1 class="text-warning my-4"><c:out value="${book.title}"/></h1>
			<a class="my-5" href="/books">BACK TO THE SHELVES</a>
		</div>
				<c:if test="${user.id==book.user.id}">
					<c:if test="${user==book.user}">
						<h3><span class="text-danger">You</span> read <span class="text-primary"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.author}"/></span></h3>
						<p class="my-3">Here are your thoughts:</p>
					</c:if>
				</c:if>
				<c:if test="${user.id!=book.user.id}">
					<c:if test="${user!=book.user}">
						<h3><span class="text-danger"><c:out value="${book.user.userName}"/></span> read <span class="text-primary"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.author}"/></span></h3>
						<p class="my-3">Here are <c:out value="${book.user.userName}"/>'s thoughts:</p>
					</c:if>
				</c:if>
				<hr>
				<div class="border border-warning border-4 rounded rounded-3 p-3">
					<div class="row mb-3 p-4">
						<p><c:out value="${book.thoughts}"/></p>
					</div>
				</div>
				<hr>
				<c:if test="${user.id==book.user.id}">
					<c:if test="${user==book.user}">
						<div>
							<a class="btn btn-warning text-light text-center" href="/books/${book.id}/edit" role="button">EDIT</a>
							<a class="btn btn-warning text-light text-center" href="/books/${book.id}/delete" role="button">DELETE</a>
						</div>
					</c:if>
				</c:if>
	</div>
</body>
</html>