<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	<style>
		.container {
			
			width: 40%;
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
		<h2>Login</h2>
		<form method="post">
			<label class="form-control-label">Username</label> <input type="text"
				name="username" id="username" class="form-control"> <label
				class="form-control-label">Password</label> <input type="password"
				name="password" id="password" class="form-control">
				<br>
			<button class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
</body>
</html>