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
<title>Nuevo propietario</title>
</head>
<body>

<div class="container" style="text-align:center;">

<div class="page-header">
			<h1>Nuevo propietario</h1>
</div>

<form:form action="../Propietario/Nuevo" method="post" modelAttribute="propietario">
		
		<form:label path="dni">DNI: </form:label>
		<form:input path="dni" />
		<br>

		<form:label path="nombre">Nombre: </form:label>
		<form:input path="nombre" />
		<br>

		<form:label path="apellido">Apellido: </form:label>
		<form:input path="apellido" />
		<br>

		<form:label path="direccion">Direccion: </form:label>
		<form:input path="direccion" />
		<br>
		
		<form:label path="telefono">Telefono: </form:label>
		<form:input path="telefono" />
		
		<br>
		<br>

		<input class="btn btn-primary btn-lg" type="submit" value="Crear propietario" />
	</form:form>
</div>
</body>
</html>