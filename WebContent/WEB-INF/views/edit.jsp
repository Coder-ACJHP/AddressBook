<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<title>Edit Address</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#">Coder Address book</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div style="margin-top: 70px;"></div>
	<div class="container-fluid">
		<div class="row justify-content-md-center">
			<div class="col-md-6">
			
				<form:form action="editProcess" modelAttribute="address" method="POST">
				<form:hidden path="id"/>
				  <div class="form-group">
				    <label for="name">First name</label>
				    <form:input type="text" class="form-control" id="name" placeholder="${address.firstName}" path="firstName" />
				  </div>
				  <div class="form-group">
				    <label for="lastName">Last name</label>
				    <form:input type="text" class="form-control" id="lastName" placeholder="${address.lastName}" path="lastName" />
				  </div>
				  <div class="form-group">
				    <label for="city">City</label>
				    <form:input type="text" class="form-control" id="city" placeholder="${address.city}" path="city"/>
				  </div>
				  <div class="form-group">
				    <label for="district">District</label>
				    <form:input type="text" class="form-control" id="district" placeholder="${address.district}" path="district"/>
				  </div>
				  <div class="form-group">
				    <label for="street">Street</label>
				    <form:input type="text" class="form-control" id="street" placeholder="${address.street}" path="street"/>
				  </div>
				  <div class="form-group">
				    <label for="Number">Number</label>
				    <form:input type="text" class="form-control" id="number" placeholder="${address.number}" path="number"/>
				  </div>
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="btn-group btn-group-justified" data-toggle="buttons">
								<div class="btn-group">
									<button type="submit" class="btn btn-outline-primary btn-lg btn-block" data-toggle="button">Submit</button>
								</div>
								<div class="btn-group">
									<button type="reset" class="btn btn-outline-success btn-lg btn-block" data-toggle="button">Clear</button>
								</div>
								<div class="btn-group">
									<button type="button" class="btn btn-outline-info btn-lg btn-block" data-toggle="button"
									onclick="window.location.href='${pageContext.request.contextPath }/allAddressess'">Return to list</button>
								</div>
							</div>
						</div>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
	<div style="margin-bottom: 10px;"></div>
</body>
</html>