<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sweetalert.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<title>Address table</title>
</head>
<body>
<c:if test="${not empty message}">
	<div class="alert alert-success" role="alert">
	  <strong>Well done!</strong><c:out value=" ${message}"></c:out>
	</div>
</c:if>
	 <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Coder Address book</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="search" method="Post">
          <input class="form-control mr-sm-2" type="text" placeholder="Search by name" aria-label="Search" name="word">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
    <div style="margin-top: 100px;"></div>
      <div class="container-fluid">
      <div class="row justify-content-md-center">
      	<div class="col-md-10">
      		<table class="table table-striped">
			  <thead class="thead-inverse">
			    <tr>
			      <th>Id</th>
			      <th>First Name</th>
			      <th>Last Name</th>
			      <th>Country</th>
			      <th>City</th>
			      <th>District</th>
			      <th>Street</th>
			      <th>Number</th>
			      <th>Edit</th>
			      <th>Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			   <c:forEach var="address" items="${addressList}">
			   
				   	<c:url var="edit" value="/editAddress">
						<c:param name="addressId" value="${address.id}" />
					</c:url>
					<c:url var="delete" value="/deleteAddress">
						<c:param name="addressId" value="${address.id}" />
					</c:url>
			   		 <tr>
				      <th scope="row"><c:out value="${address.id}" /></th>
				      <td><c:out value="${address.firstName}" /></td>
				      <td><c:out value="${address.lastName}" /></td>
				      <td><c:out value="${address.country}" /></td>
				      <td><c:out value="${address.city}" /></td>
				      <td><c:out value="${address.district}" /></td>
				      <td><c:out value="${address.street}" /></td>
				      <td><c:out value="${address.number}" /></td>
				      <td><button type="button" class="btn btn-outline-warning btn-sm" onclick="window.location='${edit}'">Edit</button></td>
				      <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="window.location='${delete}'">Delete</button></td>
				    </tr>
			   </c:forEach>
			  </tbody>
			</table>
      	</div>
      	</div>
      </div>
	<div class="container">
	<div class="btn-group">
		<div class="col-md-8 text-md-right">
			<button type="button" class="btn btn-outline-primary"  onclick="window.location='addAddress'">
				Add new address
			</button>
		</div>
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Export your table
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="saveAsJson">Export as Json</a>
		    <div class="dropdown-divider"></div>
		    <a class="dropdown-item disabled" href="#">Export as Xml</a>
		    <a class="dropdown-item disabled" href="#">Export as Txt</a>
		  </div>
		</div>
	</div>
	</div>
</body>
</html>