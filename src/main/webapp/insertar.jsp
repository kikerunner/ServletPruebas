<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Elemento creado con exito
	<br>
	<b><%= request.getParameter("name") %></b>
	<b><%= request.getParameter("apellido") %></b><br>
	<a href="/ListarPersonas.jsp"> Ir a la lista</a><br>
	<a href="/index.jsp"> Insertar más personas</a><br>
	
	
</body>
</html>