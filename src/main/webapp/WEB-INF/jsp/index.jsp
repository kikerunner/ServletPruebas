<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="/insertar" method="post">
		<span>nombre:</span> <input type="text" name="name"> <br />
		<span>apellido:</span> <input type="text" name="apellido"> <br />
		<input type="submit">
	</form>
	<a href="listarPersonas"> Ir a la lista</a><br>
	<a href="FindOwnerByPet"> Buscar mascota</a><br>
</body>
</html>