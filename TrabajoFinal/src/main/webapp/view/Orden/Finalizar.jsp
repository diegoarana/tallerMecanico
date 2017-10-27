<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" />
<title>Finalizar orden de trabajo</title>
</head>
<body>

<div class="container" style="text-align:center;">

<div class="page-header">
	<h1>Finalizar orden de trabajo</h1>
</div>

<form:form action="../FinalizarOrden/" method="post" modelAttribute="orden">

	<form:input path="estado" value="finalizado" type="hidden" />
	<form:input path="id" type="hidden" />
	<form:input path="patente" type="hidden"/>
	<form:input path="fecha_ingreso"  value="${fecha}" type="hidden"/>
	<form:input path="marca" type="hidden"/>
	<form:input path="modelo" type="hidden"/>
	<form:input path="detalle" type="hidden"/>
	<form:input path="empleado.id" type="hidden"/>
	<form:input path="propietario.id" type="hidden"/>
	
	<form:label path="cantidad_horas">Cantidad de horas trabajadas : </form:label>
		<form:input path="cantidad_horas" />
	<br><br>
	
	<label>Repuestos utilizados</label>
	<br>
	 	
	<c:forEach items="${listaRepuestos}" var="repuesto">
			<label>Cantidad de ${repuesto.nombre} : </label>
			<input type="text" name="${repuesto.id}">
			<br>
	</c:forEach>
	<br>
	
	<input class="btn btn-primary btn-lg" type="submit" value="Finalizar Orden" />
</form:form>

</div>
</body>
</html>