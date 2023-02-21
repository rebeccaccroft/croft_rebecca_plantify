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
<title>Edit Plant</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="header" class="d=flex ">
		<h1>Plantify</h1>
		<div class="d=flex justify-content-space-between">
			<a href="/dashboard"><button class="btn btn-warning">Dashboard</button></a>
			<a href="/logout"><button class="btn btn-danger">Logout</button></a>
		</div>
	</div>
	<h2 class="p-4">Edit Plant</h2>
	<div class="d-flex">
		<form:form action="/plant/${plant.id}/update" method="POST" modelAttribute="plant">
		<input type="hidden" name="_method" value="PUT" />
			<div class="p-4">
				<form:label class="form-label" path="plant_name">Name of Plant:</form:label>
				<form:input class="form-control" path="plant_name" />
				<form:errors path="plant_name" />
			</div>
			<div class="p-4">
				<form:label class="form-label" path="plant_type">Type of Plant</form:label>
				<form:select class="form-control" path="plant_type">
					<c:forEach var="type" items="${typesOfPlants}">
						<form:option class="form-control" value="${type}" />
					</c:forEach>
				</form:select>
				<form:errors path="plant_type" />
			</div>
			<div>
				<form:input type="hidden" path="createdBy" value="${user.id}" />
			</div>
			<button class="btn btn-success m-4">Submit</button>
		</form:form>
	</div>

</body>
</html>

