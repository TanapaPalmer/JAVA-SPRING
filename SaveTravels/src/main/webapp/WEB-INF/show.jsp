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
    <title>SHOW EXPENSE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container justify-content-around col-6">
		<h1 class="text-center my-3 text-warning">EXPENSE DETAILS</h1>
		<div class="d-flex justify-content-end">
			<p><a href="/expenses">GO BACK</a></p>
		</div>
		<div class="border border-warning border-4 rounded rounded-3 p-3">
	        <div class="row mb-3 p-4">
	        	<p><strong>EXPENSE NAME: </strong>${expense.name}</p>
	        	<p><strong>EXPENSE DESCRIPTION: </strong>${expense.description}</p>
	        	<p><strong>VENDOR: </strong>${expense.vendor}</p>
	        	<p><strong>AMOUNT SPENT: $</strong><fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}"/></p>
	        </div>
	    </div>
	</div>