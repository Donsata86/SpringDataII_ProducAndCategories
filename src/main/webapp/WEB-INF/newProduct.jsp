<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>


	<h2>New Product</h2>

	<form:form action="/products/new" method="post"
		modelAttribute="product">
		<tr>
			<td><form:label path="name">name:</form:label></td>
			<td><form:errors path="name" /></td>
			<td><form:input path="name" /></td>
		</tr>
		<br>
		<br>

		<tr>
			<td><form:label path="description">Description:</form:label></td>
			<td><form:errors path="description" /></td>
			<td><form:input path="description" /></td>
		</tr>
		<br>
		<br>
		<tr>
			<td><form:label path="price">Price:</form:label></td>
			<td><form:errors path="price" /></td>
			<td><form:input path="price" /></td>
		</tr>
		<br>
		<br>

		<input type="submit" value="Create" />

	</form:form>
	<a href="/categories/new">New Category</a>
</body>
</html>