<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task - Create</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/task/add" var="add"/>
	
	<!-- Header -->
	<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="container my-4">
	
		<h1> Create Task </h1>
		
		<form:form modelAttribute="task" action="${add}">
		
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="name" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="description" cssClass="form-control" maxlength="500" rows="10"/>
			</div>
			
			<div class="form-group">
				<label for="schedulingDate">Scheduling Date</label>
				<input type="date" name="schedulingDate" id="schedulingDate" value="${task.schedulingDate}"/>
			</div>
			
			<button type="submit" class="btn btn-primary">Create</button>
			
			<a href="/" class="btn btn-success">Back</a>
			
		</form:form>
		
	</div>
	
	
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	
</body>
</html>