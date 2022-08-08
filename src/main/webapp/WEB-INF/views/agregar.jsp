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

<title>Agregar producto</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#">Logistiqal</a>
	</nav>
	<h2>Agregar Producto</h2>
	<!--  <h3>${mensaje}</h3>  -->
	<c:if test="${mensaje != null ? true : false}">
        <div class="alert alert-secondary  alert-dismissible fade show"
             role="alert">${mensaje}
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
	<form action="agregar" method="post">
		<table>
			
			<tr>
                <td class="p-2"><label for="codigo">Código:</label></td>
                <td><input class="form-control" type="text"
                           placeholder="Codigo" name="codigo" /></td>
            </tr>
			<tr>
                <td class="p-2"><label for="nombre">Nombre:</label></td>
                <td><input class="form-control" type="text"
                           placeholder="Nombre" name="nombre" /></td>
            </tr>
			<tr>
                <td class="p-2"><label for="precio">Precio:</label></td>
                <td><input class="form-control" type="number" name="precio"
                           placeholder="Precio"  /></td>
            </tr>
			<tr>
                <td class="p-2"><label for="stock">Stock:</label></td>
                <td><input class="form-control" type="number" name="stock"
                           placeholder="Stock"  /></td>
            </tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn m-2 btn-success" value="Agregar" /></td>
			</tr>
		</table>
	</form>
</body>