<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NINJA GOLD GAME ACTIVITIES</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<c:forEach var="activity" items="${activities}">
		<c:if test="${activity.contains('earned')}">
			<p class="text-success"><c:out value="${activity}"></c:out></p>
		</c:if>
		<c:if test="${activity.contains('lost')}">
			<p class="text-danger"><c:out value="${activity}"></c:out></p>
		</c:if>
	</c:forEach>
</body>
</html>