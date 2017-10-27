<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Import de JSTL para utilizar los tags de Java  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<title>Nueva orden de trabajo</title>
</head>
<body>

<div class="container" style="text-align:center;">

<div class="page-header">
			<h1>Nueva orden de trabajo</h1>
</div>

<form:form action="../Nuevo" method="post" modelAttribute="orden">

		<form:select path="propietario.id">
			<form:option value="0">Seleccionar propietario del vehículo</form:option>
			<c:forEach items="${listaPropietarios}" var="pro">
				<form:option value="${pro.id}">
					<c:out value="${pro.nombre} ${pro.apellido} ${pro.dni}"></c:out>
				</form:option>
			</c:forEach>
		</form:select>
		<br>
		<br>
		
		<form:label path="patente">patente: </form:label>
		<form:input path="patente" />
		<br>

		<form:label path="fecha_ingreso">fecha_ingreso: </form:label>
		<form:input path="fecha_ingreso" />
		<br>

		<form:label path="marca">marca: </form:label>
		<form:input path="marca" />
		<br>

		<form:label path="modelo">modelo: </form:label>
		<form:input path="modelo" />
		<br>
		
		<form:label path="detalle">detalle: </form:label>
		<form:input path="detalle" />
		<br>
		
		<form:input path="estado" type="hidden" value="activo"/>
		<br>
		
		<form:select path="empleado.id">
			<form:option value="0">Seleccionar empleado</form:option>
			<c:forEach items="${listaEmpleados}" var="emp">
				<form:option value="${emp.id}">
					<c:out value="${emp.nombre} ${emp.apellido}"></c:out>
				</form:option>
			</c:forEach>
		</form:select>
		<br>
		<br>

		<input class="btn btn-primary btn-lg" type="submit" value="Generar orden de trabajo" />
	</form:form>
</div>
</body>
</html>