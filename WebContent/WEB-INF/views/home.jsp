<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<title>Address book</title>
</head>
<body>
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
      </div>
    </nav>

    <div class="jumbotron">
      <div class="container">
        <h1 class="display-3">Coder Address book</h1>
        <p>This is a simple address book web application builded on Java EE with famous frameworks like Spring, Hibernate, Bootstrap. It's includes a personal addresses and it's also mobile-friendly.</p>
        <p><a class="btn btn-primary btn-lg" href="allAddressess" role="button">Go to data table &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <h2><img src="https://extend.castsoftware.com/resources/com.castsoftware.springmvc.png" width="50px" height="50px">Spring Mvc</h2>
          <p>Spring Web MVC is the original web framework built on the Servlet API and included in the Spring Framework from the very beginning. </p>
          <p><a class="btn btn-secondary" href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2><img src="https://tools.jboss.org/features/images/hibernate_icon_256px.png" width="50px" height="50px">Hibernate 5</h2>
          <p>Hibernate ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC).</p>
          <p><a class="btn btn-secondary" href="http://hibernate.org" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2><img src="http://getbootstrap.com/assets/img/bootstrap-stack.png" width="50px" height="50px">Bootstrap 4</h2>
          <p>Bootstrap is an open source toolkit for developing with HTML, CSS, and JS. Quickly prototype your ideas or build your entire app with our Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful plugins built on jQuery.</p>
          <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Coder ACJHP 2017</p>
      </footer>
    </div>
</body>
</html>