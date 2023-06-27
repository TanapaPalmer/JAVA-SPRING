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
    <title>NEW DOJO</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
		<h2 class="text-primary text-center p-3">NEW DOJO</h2>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/dojos" mode="post" modelAttribute="dojo"  class="card col-5 p-4 mx-auto bg-default shadow border border-primary border-4 rounded rounded-3">
				
				<form:label path="name" class="text-primary"/>
				<form:errors path="name" class="text-danger"/>
		        <form:input path="name" class="form-control"/><br>
		        
		        <input type="submit" value="Create" class="btn btn-primary text-light text-center"/>
		        
			</form:form>
		</div>
	</div>
</body>
</html>