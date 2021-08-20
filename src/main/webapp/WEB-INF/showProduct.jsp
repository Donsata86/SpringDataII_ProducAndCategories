<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>

	<a href="/">Home</a> |
	<a href="/products/new">New Product</a> |
	<a href="/categories/new">New Category</a>

	<h1>
		<c:out value="${product.name}" />
	</h1>
	
	<h3>Categories:</h3>
	<ul>
		<c:forEach items="${product.categories}" var="category">
			<li><h2>
					<c:out value="${category.name}" />
				</h2></li>
		</c:forEach>
	</ul>

	<h4>Add a Category</h4>
	<form action="/products/${product.id}" method="POST">

		<label for="category">Category:</label> <select name="category">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">
					<c:out value="${category.name}" /></option>
			</c:forEach>
		</select> <input type="submit" value="Add" />

	</form>






</body>
</html>

