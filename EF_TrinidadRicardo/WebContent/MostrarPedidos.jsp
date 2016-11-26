<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Pedidos</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mostrar-carrito.css" />
</head>
<script type="text/javascript">
	function eliminarItem(id){
		$("#idSeleccionado").val(id);
		$("#accion").val("ELIMINAR");
		$("#miCarritoForm").submit();
	}

	function modificarCantidad(id, cantidad, descripcion){
		$("#idEdicion").val(id);
		$("#descripcion").val(descripcion);
		$("#cantidadEdicion").val(cantidad);
		$('#editarCantidad').modal('toggle');
	}

	function actualizar(){
		$("#idSeleccionado").val($("#idEdicion").val());
		$("#accion").val("EDITAR");
		$("#cantidad").val($("#cantidadEdicion").val());
		$("#miCarritoForm").submit();
	}
</script>
<body>
	<div class="container">
		<div class="row col-md-6 col-md-offset-2 custyle">
			<form id="miCarritoForm" name="miCarritoForm" 
				  action="GestionarPedido" method="POST">
			<input type="hidden" name="idSeleccionado" id="idSeleccionado" />
			<input type="hidden" name="accion" id="accion" value="MOSTRAR"/>
			<input type="hidden" name="cantidad" id="cantidad" />
			<table class="table table-striped custab">
				<thead>					
					<tr>
						<th>Id</th>
						<th>Producto</th>
						<th>Cantidad</th>
						<th>Cliente</th>
						<th>Estado</th>
						<th class="text-center">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pedidos.pedidosFromDB}" var="x">
						<tr>
							<td>${x.id}</td>
							<td>${x.producto.descripcion}</td>
							<td>${x.cantidad}</td>
							<td>${x.cliente.nombre}</td>
							<td>${x.estado}</td>
							<td class="text-center">
								<button type="button" 
									onclick="eliminarItem(${x.id});" 
									class="btn btn-danger btn-xs">
									<span class="glyphicon glyphicon-remove"></span> 
									Actualizar Estado
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<a href="GestionarPedido" class="btn btn-primary btn-xs pull-right"><b>+</b>
						Agregar Pedido</a>
			</table>
			</form>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
	    <br/><br/><br/>
	        <div class="modal fade" id="editarCantidad" tabindex="-1" role="dialog" aria-labelledby="tituloEdicion" aria-hidden="true">
	            <div class="modal-dialog">
	                <div class="panel panel-primary">
	                    <div class="panel-heading">
	                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                        <h4 class="panel-title" id="tituloEdicion"><span class="glyphicon glyphicon-edit"></span>Editar la cantidad del item </h4>
	                    </div>
	              
	                    <div class="modal-body" style="padding: 5px;">
	                          <div class="row">
	                                <div class="col-lg-6 col-md-6 col-sm-6" style="padding-bottom: 10px;">
	                                    <input class="form-control" name="idEdicion" type="text" readonly id="idEdicion"/>
	                                </div>
	                                <div class="col-lg-6 col-md-6 col-sm-6" style="padding-bottom: 10px;">
	                                    <input class="form-control" name="descripcion" type="text" readonly id="descripcion"/>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-lg-12 col-md-12 col-sm-12" style="padding-bottom: 10px;">
	                                    <input class="form-control" name="cantidadEdicion" placeholder="Cantidad..."
	                                    	id="cantidadEdicion" 
	                                    	type="text" required autofocus/>
	                                </div>
	                            </div>
	                           
	                        </div>  
	                        <div class="panel-footer" style="margin-bottom:-14px;">
	                            <input type="button" class="btn btn-success" value="Actualizar"
	                            	onclick="actualizar();"/>
	                                <!--<span class="glyphicon glyphicon-ok"></span>-->
	                                <!--<span class="glyphicon glyphicon-remove"></span>-->
	                            <button style="float: right;" type="button" class="btn btn-default btn-close" data-dismiss="modal">Cerrar</button>
	                        </div>
	                       
	                    </div>
	                </div>
	            </div>
	        </div>

	</div>
 	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/mostrar-carrito.js"></script>
</body>
</html>