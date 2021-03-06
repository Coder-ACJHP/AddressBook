<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<style type="text/css">.cssError { margin-top: 10px;}</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<title>Address form</title>
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
		</div>
	</nav>
	<div style="margin-top: 70px;"></div>
	<div class="container-fluid">
		<div class="row justify-content-md-center">
			<div class="col-md-6">
				<form:form action="addProcess" modelAttribute="address" method="POST">
				<form:hidden path="id"/>
				  <div class="form-group">
				    <label for="name">First name</label>
				    <form:input type="text" class="form-control" id="name" placeholder="${address.firstName}" path="firstName" />
				  	<form:errors path="firstName" cssClass="alert alert-danger" />
				  </div>
				  <div class="form-group">
				    <label for="lastName">Last name</label>
				    <form:input type="text" class="form-control" id="lastName" placeholder="${address.lastName}" path="lastName" />
				    <form:errors path="lastName" cssClass="alert alert-danger" />
				  </div>
				   <div class="form-group">
				    <label for="city">Country</label>
				    <form:select path="country" class="form-control">
				    	<form:options items="${theCountryOptions}"/>
				    </form:select>
				    <form:errors path="country" cssClass="alert alert-danger" />
				  </div>
				  <div class="form-group">
				    <label for="city">City</label>
				    <form:input type="text" class="form-control" id="city" placeholder="${address.city}" path="city"/>
				  	<form:errors path="city" cssClass="alert alert-danger" />
				  </div>
				  <div class="form-group">
				    <label for="district">District</label>
				    <form:input type="text" class="form-control" id="district" placeholder="${address.district}" path="district"/>
				  	<form:errors path="district" cssClass="alert alert-danger" />
				  </div>
				  <div class="form-group">
				    <label for="street">Street</label>
				    <form:input type="text" class="form-control" id="street" placeholder="${address.street}" path="street"/>
				 	 <form:errors path="street" cssClass="alert alert-danger" />
				  </div>
				  <div class="form-group">
				    <label for="Number">Number</label>
				    <form:input type="text" class="form-control" id="number" placeholder="${address.number}" path="number"/>
				 	<form:errors path="number" cssClass="alert alert-danger" />
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