<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productos disponibles</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mostrar-carrito.css" />
</head>
<body>
	<div class="container">
		<div class="row col-md-6 col-md-offset-2 custyle">
			<form 	id="formAgregarProducto" 
					action="AgregarProductoServlet" method="POST">
				<input type="hidden" name="codigoSeleccionado" id="codigoSeleccionado">
				<input type="hidden" name="cantidadAgregada" id="cantidadAgregada">
			</form>
			<table class="table table-striped custab">
				<thead>
					<a href="MostrarCarrito.jsp" 
							class="btn btn-primary btn-xs pull-right">
						Volver
					</a>
					<tr>
						<th>ID</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Cantidad disponible</th>
						<th>Cantidad a comprar</th>
						<th class="text-center">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productos}" var="x">
						<tr>
							<td>${x.id}</td>
							<td>${x.descripcion}</td>
							<td>${x.precio}</td>
							<td>${x.cantidadEnStock}</td>
							<td>
								<input type="text" value="1" 
									name="${x.id}_cantidad" id="${x.id}_cantidad">
								</input>
							</td>
							<td class="text-center">
								
								<button type="button" onclick="agregarProducto(${x.id}, ${x.id}_cantidad);"
									class="btn btn-success btn-lg">
									<span class="glyphicon glyphicon-plus"></span> 
									Agregar
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript">
		function agregarProducto(idProducto, campoCantidad){
			$("#codigoSeleccionado").val(idProducto);
			$("#cantidadAgregada").val($(campoCantidad).val());
			$("#formAgregarProducto").submit();
		}
	</script>
</body>
</html>