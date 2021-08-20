<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
<h2>New Category</h2>

	<form:form action="/categories/new" method="post"
		modelAttribute="category">
		<tr>
			<td><form:label path="name">name:</form:label></td>
			<td><form:errors path="name" /></td>
			<td><form:input path="name" /></td>
		</tr>
		<br>
		<br>

		<input type="submit" value="Create" />

	</form:form>
	
	<a href="/products/new">New Product</a>

</body>
</html>