<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OMIKUJI FORM</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center my-3 text-success">SEND AN OMIKUJI</h1>
		<form action="/submitForm" method="post" class="card col-5 mx-auto bg-default p-3 shadow border border-success border-4 rounded rounded-3">
	    	<div class="form-group p-2">
	        	<div>
		            <label for="number" class="form-label p-2">PICK ANY NUMBER FROM 5 TO 25</label>
		            <input type="number" name="number" id="number" class="form-control p-2">
		            <label for="city" class="form-label p-2">ENTER THE NAME OF ANY CITY</label>
		            <input type="text" name="city" id="city" class="form-control p-2">
		            <label for="person" class="form-label p-2">ENTER THE NAME OF ANY REAL PERSON</label>
		            <input type="text" name="person" id="person" class="form-control p-2">
		            <label for="hobby" class="form-label p-2">ENTER PROFESSIONAL ENDEAVOR OR HOBBY:</label>
		            <input type="text" name="hobby" id="hobby" class="form-control p-2">
		            <label for="livingthing" class="form-label p-2">ENTER ANY TYPE OF LIVING THING</label>
		            <input type="text" name="livingthing" id="livingthing" class="form-control p-2">                    
		            <label for="saysomething" class="form-label p-2">SAY SOMETHING NICE TO SOMEONE:</label>
		            <textarea name="saysomething" id="saysomething" class="form-control p-2"></textarea>
		            <p><strong>SEND AND SHOW A FRIEND</strong></p>
		            <input type="submit" value="Send" class="btn btn-success text-light text-center">
	            </div>
			</div>
		</form>
</body>
</html>