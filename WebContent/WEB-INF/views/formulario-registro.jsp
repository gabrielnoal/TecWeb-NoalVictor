<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Registro de usuário</h2>
<form action="efetuaRegistro" method="post" enctype="multipart/form-data">
 Login: <input type="text" name="login" /> <br/>
 Senha: <input type="password" name="senha" /> <br/>
 Foto: <input type="file" name="foto"/> <br/><br/>
 <input type="submit" value="Registrar" />
</form>
</body>
</html>