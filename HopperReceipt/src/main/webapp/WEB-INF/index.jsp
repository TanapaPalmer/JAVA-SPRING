<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOPPER'S RECEIPT</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="border border-dark border-4 rounded rounded-3 p-3 col-7 my-5">
		<div>
			<h1 class="my-3"><strong>Customer Name: </strong><c:out value="${name}"/></h1>
			<p class="my-3"><strong>Item Name: </strong><c:out value="${itemName}"/></p>
			<p class="my-3"><strong>Price: </strong>$<c:out value="${price}"/></p>
			<p class="my-3"><strong>Description: </strong><c:out value="${description}"/></p>
			<p class="my-3"><strong>Vendor: </strong><c:out value="${vendor}"/></p>
		</div>
	</div>
	<hr>
		<div class="border border-dark border-4 rounded rounded-3 p-3 col-7 my-5">
		<div>
			<h1 class="my-3"><strong>Customer Name: </strong><c:out value="${nameTwo}"/></h1>
			<p class="my-3"><strong>Item Name: </strong><c:out value="${itemName}"/></p>
			<p class="my-3"><strong>Price: </strong>$<c:out value="${price}"/></p>
			<p class="my-3"><strong>Description: </strong><c:out value="${description}"/></p>
			<p class="my-3"><strong>Vendor: </strong><c:out value="${vendor}"/></p>
		</div>
	</div>
</body>
</html>