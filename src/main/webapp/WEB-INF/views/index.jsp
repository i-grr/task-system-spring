<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks - Home</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="task/edit" var="edit"/>
	<spring:url value="task/delete" var="delete"/>

	<!-- Header -->
	<jsp:include page="./common/header.jsp"></jsp:include>
		
	<div class="container my-4">		
	
		<c:if test="${not empty success}">
			<div class="alert alert-success my-2" role="success">
				${success}
			</div>
		</c:if>
		
		<div class="jumbotron">
			<h1>Tasks to perform</h1>
		</div>
		
		<!-- Verificando se a lista não é nula -->
		<c:if test="${not empty tasks}">
			<table class="table">
		
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Scheduling Date</th>
					<th>Creation Date</th>
					<th colspan="2">Actions</th>
				</tr>
			
				<c:forEach var="task" items="${tasks}">
					
					<tr>
						<td>${task.id}</td>
						<td>${task.name}</td>	
						<td>${task.schedulingDate}</td>
						<td>${task.creationDate}</td>
						<td><a href="${edit}/${task.id}" class="btn btn-warning">Edit</a></td>
						<td><a href="${delete}/${task.id}" class="btn btn-danger">Delete</a></td>
					</tr>
			
				</c:forEach>
		
			</table>
		</c:if>
		
	</div>
	
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	
</body>
</html>