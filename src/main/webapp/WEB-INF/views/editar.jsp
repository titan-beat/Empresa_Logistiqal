<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
<title>Edición de Producto </title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">Logistiqal</a>
</nav>
	<h1>EDITAR PRODUCTO</h1>
	<h3>${mensaje}</h3>
	<form action="editar" method="post">
		<table>
			<input type="hidden" value="${miProducto.getId()}"
				name="id" />

			<tr>
				<td>Código:</td>
				<td><input class="form-control" type="text" name="codigo"
					value="${miProducto.getCodigo()}" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input class="form-control" type="text" name="nombre"
					value="${miProducto.getNombre()}" /></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input class="form-control" type="number" name="precio"
					maxlength="99999999" value="${miProducto.getPrecio()}" /></td>
			</tr>
			<tr>
				<td>Stock:</td>
				<td><input class="form-control" type="number" name="stock"
					maxlength="99999999" value="${miProducto.getStock()}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>