<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Login & Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/static.js"></script>
</head>
<body>
	<header>
		<h1 class="d-flex justify-content-center p-5">Plantify</h1>
		<h3 class="d-flex justify-content-center p-2">~ Gotta Eat 'Em All ~</h3>
	</header>
	
	<div class="d-flex justify-content-center p-5">
		
		<form:form action="/register" method="POST" modelAttribute="user">
		<h3 >Register Here</h3>
			<div class="p-2">
				<form:label path="username">Username: </form:label>
				<form:input class="form-control" path="username" />
				<form:errors path="username"/>
			</div>
			<div class="p-2">
				<form:label path="email">Email:  </form:label>
				<form:input class="form-control" path="email" />
				<form:errors path="email"/>
			</div>
			<div class="p-2">
				<form:label path="password">Password: </form:label>
				<form:input  class="form-control" path="password" type="password"/>
				<form:errors path="password"/>
			</div>
			<div class="p-2">
				<form:label path="confirmPass">Confirm Password:  </form:label>
				<form:input class="form-control" path="confirmPass" type="password"/>
				<form:errors path="confirmPass"/>
			</div>
			<div class="p-2">
				<form:label path="goal">What is Your Goal of Plants per Week?  </form:label>
				<form:input class="form-control" path="goal" />
				<form:errors path="goal"/>
			</div>
			<button class="btn btn-success">Submit</button>
		</form:form>
		</div>
		<div class="d-flex justify-content-center p-5">
		<form:form action="/login" method="POST" modelAttribute="loginUser">
			<h3>Login Here</h3>
			<div class="p-2">
				<form:label class="form-label "  path="username">Username: </form:label>
				<form:input class="form-control" path="username"/>
				<form:errors path="username"/>
			</div>
			<div class="p-2">
				<form:label class="form-label"  path="password">Password: </form:label>
				<form:input class="form-control"  path="password" type="password"/>
				<form:errors path="password"/>
			</div>
			<button class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>

