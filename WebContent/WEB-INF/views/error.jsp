<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Error</title>
</head>
<body>
	<div class="own-background">
		<div align="center">
			<div class="header">
				${headError}
			</div>
			<div class="message">
				${errorBody}
			</div>
			<button class="btn" type="button" onclick="window.location.href='${pageContext.request.contextPath}/'">Back to home</button>
		</div>
	</div>
</body>
</html>