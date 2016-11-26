<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos del Carrito</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mostrar-carrito.css" />
</head>
<body>
	<div class="container">
		<div class="row col-md-6 col-md-offset-2 custyle">
			<table class="table table-striped custab">
				<thead>
					<a href="AgregarProducto" class="btn btn-primary btn-xs pull-right"><b>+</b>
						Agregar producto</a>
					<tr>
						<th>ID</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Cantidad en Stock</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${session.carrito.items}" var="x">
					<tr>
						<td>${x.producto.id}</td>
						<td>${x.producto.descripcion}</td>
						<td>${x.producto.precio}</td>
						<td>${x.cantidad}</td>
						<td class="text-center"><a class='btn btn-info btn-xs'
						href="#"><span class="glyphicon glyphicon-edit"></span> Modificar Cantidad</a> <a
						href="#" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span>Eliminar</a></td>
				</c:forEach>
				</tbody>
				<tr>
					<td>1</td>
					<td>News</td>
					<td>News Cate</td>
					<td>News Cate</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="#" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Products</td>
					<td>Main Products</td>
					<td>Main Products</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="#" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
				<tr>
					<td>3</td>
					<td>Blogs</td>
					<td>Parent Blogs</td>
					<td>Parent Blogs</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="#" class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>