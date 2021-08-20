<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page!</title>
</head>
<body>
</head>
<body>
	<h3 class="text-center">
		<a href="/">Home</a> | <a href="/products/new">New Product</a> | <a
			href="/categories/new">New Category</a>
	</h3>
	<h1 class="text-center">
		<c:out value="${category.name}" />
	</h1>
	<h2>Products:</h2>
	<ul>
		<c:forEach items="${category.products}" var="product">
			<li><h2>
					<c:out value="${product.name}" />
				</h2></li>
		</c:forEach>
	</ul>
	<h2>Add a Product</h2>
	<form action="/categories/${ category.id }" method="POST">
		<div class="form-group" style="font-size: 30px;">
			<label for="product">Product:</label> <select name="product">
				<c:forEach items="${ products }" var="product">
					<option value="${ product.id }"><c:out
							value="${ product.name }" /></option>
				</c:forEach>
			</select>
		</div>
		<div class="row justify-content-center p-4">
			<input type="submit" style="font-size: 30px;" value="Add"
				class="btn btn-success" />
		</div>
	</form>

</body>

</body>
</html>