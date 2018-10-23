<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
 <h2>Página inicial da Lista de Tarefas</h2>
 <p>Bem vindo, ${usuarioLogado}</p>
 
 <img src="getImage?login=${usuarioLogado}" />
 
 <a href="listaTarefas">Clique aqui</a> para acessar a lista de tarefas <br>
 <a href="logout">Sair do sistema</a>
</body>
</body>
</html>