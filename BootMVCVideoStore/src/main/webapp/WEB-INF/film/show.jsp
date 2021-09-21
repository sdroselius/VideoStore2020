<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Film Details</title>
    <jsp:include page="../bootstrapHead.jsp"></jsp:include>
	
</head>
<body>
	<div>
		<h5>${film.title}(${film.releaseYear})</h5>
		<p>${film.description}</p>
	</div>

<jsp:include page="../bootstrapFoot.jsp"></jsp:include>
</body>
</html>