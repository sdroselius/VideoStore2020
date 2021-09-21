<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Video Store</title>
    <jsp:include page="bootstrapHead.jsp"></jsp:include>
</head>
<body>

<div class="container-fluid">
	<form class="form" action="getFilm.do" method="GET">
		Film ID: <input type="text" name="fid" />
		<input class="btn btn-primary" type="submit" value="Show Film" />
	</form>

	<table class="table table-striped table-hover">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Title</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="f" items="${films }">
				<tr>
					<td>${f.id }</td>
					<td><a href="getFilm.do?fid=${f.id}"> ${f.title} </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="bootstrapFoot.jsp"></jsp:include>
</body>
</html>