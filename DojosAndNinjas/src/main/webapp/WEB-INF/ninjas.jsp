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
    <title>NEW NINJAS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container justify-content-center col-8">
		<h2 class="text-primary text-center p-3">NEW NINJA</h2>
        <div class="form-group d-flex justify-content-center my-3">
			<form:form action="/ninjas" mode="post" modelAttribute="ninja"  class="card col-5 p-4 mx-auto bg-default shadow border border-primary border-4 rounded rounded-3">
				
				<p><strong>DOJO:</strong></p>
				<form:select path="dojo">
					<c:forEach var="dojoLocation" items="${dojos}">
						<option value="${dojoLocation.id}"><c:out value="${dojoLocation.name}"/></option>
					</c:forEach>
				</form:select><br>
				
				<form:label path="firstName" class="form-label"><strong>FIRST NAME:</strong></form:label>
				<form:errors path="firstName" class="text-danger"/>
		        <form:input path="firstName" class="form-control"/>
		        
		        <form:label path="lastName" class="form-label"><strong>LAST NAME:</strong></form:label>
				<form:errors path="lastName" class="text-danger"/>
		        <form:input path="lastName" class="form-control"/>
		        
		        <form:label path="age" class="form-label"><strong>AGE:</strong></form:label>
				<form:errors path="age" class="text-danger"/>
		        <form:input type="number" path="age" class="form-label"/><br>
		        
		        <input type="submit" value="Create" class="btn btn-primary text-light text-center"/>
		        
			</form:form>
		</div>
	</div>
</body>
</html>