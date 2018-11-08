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
<form action="/insertar" method="post">
		<span>ID:</span> <input type="text" name="CodPersona" value="<c:out value="${personaEditar.CodPersona}"/>"> <br />
		<span>nombre:</span> <input type="text" name="name" value="<c:out value="${personaEditar.name}"/>"> <br />
		<span>apellido:</span> <input type="text" name="apellido" value="<c:out value="${personaEditar.apellido}"/>"> <br />
		<input type="submit">
	</form>
</body>
</html>