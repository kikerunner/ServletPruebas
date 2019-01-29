<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cargarListado" method="post">

	<input type="submit" value="ver listado">

</form>
<table border="1">

	<thead>
		<tr>
			<td>Cod Persona</td>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Editar</td>
			<td>Borrar</td>
			<td>Añadir Mascota</td>
			<td>Mascotas</td>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="persona" items="${cargarListado}">
			<tr>
				<td><c:out value="${persona.codPersona}"/> </td>
				<td><c:out value="${persona.name}"/> </td>
				<td><c:out value="${persona.apellido}"/> </td>
				<td><a href="/editar?codPersona=${persona.codPersona}">EDIT</a> </td>
				<td><a href="/confirmarDelete?codPersona=${persona.codPersona}">DELETE</a> </td>
				<td><a href="/addPet?codPersona=${persona.codPersona}">Añadir Mascota</a> </td>
				<td>
	    			<c:forEach var="pet" items="${persona.mascotas}">
	    				<c:out value="${pet.nomMascota}"/><br>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>