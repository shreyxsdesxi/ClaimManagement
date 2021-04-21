<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bills</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	<style>
		.container {
			
			width: 50%;
			margin: auto;
			margin-top: 100px;
		}
	</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<a class="navbar-brand" href="#" style="color: white; margin-left: 20px">Generic Insurance Website</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<!--  <li class="nav-item active"><a class="nav-link" href="#" style="color: white;">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#" style="color: white;">Features</a></li>
				<li class="nav-item"><a class="nav-link" href="#" style="color: white;">Pricing</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true" style="color: white;">Disabled</a></li>-->
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>Submit A Claim</h2>
		<form method="post" action="/submitClaim">
			<div class="form-group">
    			<label for="exampleInputEmail1">Policy Id</label>
    			<select class="form-control" style="width: 20%" name="policyId" id="policyId">
    				<c:forEach items="${policy}" var="item">
    					<option value="${item.policyId}">${item.policyId}</option>
    				</c:forEach>
    			</select>
    			<small id="emailHelp" class="form-text text-muted">Choose Policy ID</small>
  			</div>
  			
  			<div class="form-group">
    			<label for="exampleInputEmail1">Hospital</label>
    			<select class="form-control" style="width: 40%" name="hospitalId" id="hospitalId">
    				<option value="1">Newlife Hospital, Kolkata</option>
    				<option value="2">Red Cross Hospital, Pune</option>
    				<option value="3">Cambridge Hospital, Bangalore</option>
    				<option value="4">Newlife Hospital, Chennai</option>
    				<option value="5">Newlife Hospital, Mumbai</option>
    			</select>
    			<small id="emailHelp" class="form-text text-muted">Choose Hospital</small>
  			</div>
			
			<div class="form-group">
    			<label for="exampleInputEmail1">Amount</label>
    			<input type="number" name="amount" id="amount" class="form-control" placeholder="Amount" style="width: 40%">
    			<small id="emailHelp" class="form-text text-muted">Enter claim amount</small>
  			</div>
			<br>	
			<button type="submit" class="btn btn-success">Submit</button>
			
		</form>
		
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
</body>
</html>