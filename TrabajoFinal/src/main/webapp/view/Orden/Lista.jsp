<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Import de JSTL para utilizar los tags de Java  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />

<title>Inicio Taller</title>
</head>

<body>

<div class="container">
		<div class="page-header">
			<h1>Lista de ordenes de trabajo</h1>
		</div>
		<div class="col-md-2">
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/Orden/Nuevo/" role="button">Nueva orden</a>
		</div>
		<div class="col-md-2">
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/Propietario/Nuevo" role="button">Nuevo propietario</a>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Fecha ingreso</th>
					<th>Patente</th>
					<th>Marca</th>
					<th>Modelo</th>
					<th>Detalle</th>
					<th>Estado</th>
					<th>Horas</th>
					<th>Costo final</th>
					<th>Finalizar Orden</th>
					<th>Detalle costo</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty listaOrden}">
					<c:forEach items="${listaOrden}" var="orden">
						<tr>
							<td><c:out value="${orden.fecha_ingreso}"></c:out></td>
							<td><c:out value="${orden.patente}"></c:out></td>
							<td><c:out value="${orden.marca}"></c:out></td>
							<td><c:out value="${orden.modelo}"></c:out></td>
							<td><c:out value="${orden.detalle}"></c:out></td>
							<td><c:out value="${orden.estado}"></c:out></td>
							<td>
							<c:if test="${orden.cantidad_horas != 0 }">
							<c:out value="${orden.cantidad_horas}"></c:out>
							</c:if>
							
							</td>
							<td>
							<c:if test="${orden.costoFinal != 0 }">
							<c:out value="${orden.costoFinal}"></c:out>
							</c:if>
							</td>
							<td>
							<c:if test="${orden.estado == 'activo' }">
							<a href="Finalizar/${orden.id}">Finalizar</a>
							</c:if>
							</td>
							<td>
							<c:if test="${orden.estado == 'finalizado' }">
							<a href="CostoDetalle/${orden.id}">Detalles</a>
							</c:if>
							</td>
						</tr>

					</c:forEach>
				</c:if>
				<c:if test="${empty listaOrden}">
					<tr>
						<td colspan="5">No hay datos disponibles por el momento</td>
					</tr>
				</c:if>

			</tbody>
		</table>

	</div>

</body>
</html>