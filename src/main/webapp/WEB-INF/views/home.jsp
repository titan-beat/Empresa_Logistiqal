<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Bienvenido bem-vindo</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand ms-3" href="/inicio">Logistiqal</a>
	</nav>
<div class="p-3">
	<h3>${mensaje}</h3>
	<a href="agregarForm" class="btn m-2 btn-success">Agregar Producto</a>

	<form method="POST" action="buscar">
		<table>
			<tr>
				<td class="p-2"><label for="producto">Buscador:</label></td>
				<td><input class="form-control" type="text"
					placeholder="Buscar por nombre" name="productoBuscado" /></td>
				<td colspan="2"><input type="submit"
					class="btn m-2 btn-primary" value="Buscar" /></td>
			</tr>
		</table>
	</form>

	<table border="1" class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Stock</th>
				<th>Acciones</th>
			</tr>
			<c:forEach items="${VO.productos}" var="u">
				<tr>
					<td>${u.getCodigo()}</td>
					<td>${u.getNombre()}</td>
					<td>${u.getPrecio()}</td>
					<td>${u.getStock()}</td>
					<td>
						<div>
							<a href="editarForm?id=${u.getId()}" class="btn btn-primary btn-sm">Editar</a> 
							<a href="eliminar?id=${u.getId()}" class="btn btn-danger btn-sm">Eliminar</a>
						</div>
					</td>
				</tr>
			</c:forEach>
	</table>
</div>
</body>
</html>