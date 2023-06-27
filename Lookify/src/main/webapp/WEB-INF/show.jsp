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
    <title>SHOW SONG</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-around col-6 my-5">
		<div class="border border-dark border-4 rounded rounded-3 p-3">
	        <div class="row mb-3 p-4">
		        <h1>SONG DETAILS</h1>
	        	<p class="my-3"><strong>TITLE: </strong>${song.title}</p>
	        	<p class="my-3"><strong>ARTIST: </strong>${song.artist}</p>
	        	<p class="my-3"><strong>RATING: </strong>${song.rating}</p>
	        </div>
	    </div>
		<div class="my-2">
		    <a class="btn btn-warning text-light text-center col-2" href="/dashboard" role="button">DASHBOARD</a>
		</div>
	</div>
</body>
</html>