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
    <title>LOGIN AND REGISTRATION</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-13">
		<h1 class="p-3 text-center"><strong>WELCOME!</strong></h1>
		<h4 class="text-center">JOIN OUR COMMUNITY</h4>
        <div class="d-flex justify-content-center my-3">
			<form:form action="/register" mode="post" modelAttribute="newUser"  class="card col-5 p-4 mx-auto shadow border border-light bg-success border-4 rounded rounded-3 text-light">
				<h2 class="text-center p-3 text-success bg-light"><strong>REGISTER</strong></h2>
				<div class="d-flex justify-content-between p-2">
				<form:label path="userName" class="form-label"><strong>USER NAME:</strong></form:label>
				<form:errors path="userName" class="text-danger"/>
		        <form:input type="text" path="userName" class="col-6"/>
		        </div>
		        <hr>
				<div class="d-flex justify-content-between p-2">
		        <form:label path="email" class="form-label"><strong>EMAIL:</strong></form:label>
				<form:errors path="email" class="text-danger"/>
		        <form:input type="email" path="email" class="col-6"/>
		        </div>
		 		<hr>       
		        <div class="d-flex justify-content-between p-2">
		        <form:label path="password" class="form-label"><strong>PASSWORD:</strong></form:label>
				<form:errors path="password" class="text-danger"/>
		        <form:input type="password" path="password" class="col-6"/>
		        </div>
		        <hr>
		        <div class="d-flex justify-content-between p-2">
		        <form:label path="confirm" class="form-label"><strong>CONFIRM PASSWORD:</strong></form:label>
		       	<form:errors path="confirm" class="text-danger"/>
		        <form:input type="password" path="confirm" class="col-6"/>
		        </div>
		        <hr>
		        <div class="d-flex justify-content-center p-2">
		        <input type="submit" value="SUBMIT" class="btn btn-light text-success text-center col-12"/>
		        </div>
			</form:form>
		</div>
		<hr>
        <div class="d-flex justify-content-center my-3">
			<form:form action="/login" mode="post" modelAttribute="newLogin"  class="card col-5 p-4 mx-auto shadow border border-light bg-success border-4 rounded rounded-3 text-light">
				<h2 class="text-center p-3 text-success bg-light"><strong>LOGIN</strong></h2>
				<hr>
				<div class="d-flex justify-content-between p-2">
		        <form:label path="email" class="form-label"><strong>EMAIL:</strong></form:label>
				<form:errors path="email" class="text-danger"/>
		        <form:input path="email" class="col-6"/>
		        </div>
		 		<hr>       
		        <div class="d-flex justify-content-between p-2">
		        <form:label path="password" class="form-label"><strong>PASSWORD:</strong></form:label>
				<form:errors path="password" class="text-danger"/>
		        <form:input type="password" path="password" class="col-6"/>
		        </div>
		        <hr>
		        <div class="d-flex justify-content-center p-2">
		        <input type="submit" value="SUBMIT" class="btn btn-light text-success text-center col-12"/>
		        </div>
			</form:form>
		</div>
	</div>
</body>
</html>