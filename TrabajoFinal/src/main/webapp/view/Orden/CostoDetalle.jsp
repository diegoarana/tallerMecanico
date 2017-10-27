<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle del costo</title>
</head>
<body>

<div class="container" style="text-align:center;">

<div class="page-header">
	<h1>Detalles del costo final</h1>
</div>

<table class="table table-hover">
	<thead>
		<tr>
		<th>Repuesto</th>
		<th>Cantidad</th>
		<th>Precio</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${listaOrdenRepuestos}" var="rep">
		 
	<tr>
		<td>${rep.repuesto.nombre}</td>
		<td>${rep.cantidad} </td>
		<td>${rep.repuesto.precio} </td>
	</tr>
	</c:forEach>
	</tbody>
</table>
	<h3>Cantidad de horas de trabajo(PrecioXhora $150): ${orden.cantidad_horas} </h3>
	<br>
	
	<h2>Costo total final ${orden.costoFinal}</h2>
</div>

</body>
</html>