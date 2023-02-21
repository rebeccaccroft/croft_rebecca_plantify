<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plantify Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/static.js"></script>
</head>
<body>
	<div id="header" class="d=flex-inline">
		<h1>Plantify</h1>
		<a href="/logout"><button class="btn btn-danger">Logout</button></a> 
	</div>

	<div>
		<a href="/plant/form/create" class="btn btn-success">Add A New
			Plant!</a>
	</div>
	<div class="text-center p-4 text-decoration-underline" >
		<h4>My Goal ~ <c:out value="${user.goal }" /> plants per week</h4>
	</div>
	<div class="d-flex justify-content-center">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Type</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="plant" items="${user.plants}">
					<tr>
						<td>${plant.plant_name.toLowerCase() }</td>
						<td>${plant.plant_type.toLowerCase() }</td>
						<td><a href="/plant/form/${plant.id }/update"
							class="btn btn-success">Update</a> <a
							href="/plant/${plant.id }/delete" class="btn btn-success">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

