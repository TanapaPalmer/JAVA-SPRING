<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SHOW OMIKUJI</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-around">
		<h1 class="text-center my-3 text-success">HERE'S YOUR OMIKUJI</h1>
		<div class="border border-success border-4 rounded rounded-3 p-3">
	        <div class="row mb-3 p-4 text-center">
	        	<h4>${result}</h4>
	        </div>
	    </div>
	</div>
</body>
</html>