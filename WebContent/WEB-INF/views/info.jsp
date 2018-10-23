<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*, mvc.model.*" %>
<div id="ognwrapper">
		<header class="gb_Ta gb_qb gb_Ed gb_Kd" ng-non-bindable="" id="gb"
			role="banner" style="background-color: #fb0">
			<div class="gb_je"></div>
			<h1>WebKeep</h1>
	</div>

	<form action="criaTarefa" method="post">
	 	Nota: <input id="tarefa-input" type="text" name="tarefa" /> <br/>
 	<input type="submit" value="Criar" />
 	</form> 
	
<table border='0'>
<% TarefasDAO dao = new TarefasDAO();
 List<Tarefa> tarefas = dao.getLista();
 for (Tarefa tarefa : tarefas ) { %>
 <tr>
 <td> 	
 </br>
 	<form action="alteraTarefa" method="post">
	 	<input id="tarefa-input" type="text" name="tarefa" value="<%=tarefa.getDescricao()%>"/> 
	 	<input type="hidden" name="data" value="<%=tarefa.getDataFinalizacao()%>"/>
	 	<input type="hidden" name="id" value="<%=tarefa.getId()%>"/>
	 	<input type="submit" value="Editar" />
 	</form> 
 	<form action="deletaTarefa" method="post">
 		<input type="hidden" name="data" value="<%=tarefa.getDataFinalizacao()%>"/>
	 	<input type="hidden" name="id" value="<%=tarefa.getId()%>"/>
	 	<input type="submit" value="X" />
 	</form> 	
	<form action="toSpotify" method="post">
		<input type="hidden" name="tarefa" value="<%=tarefa.getDescricao()%>"/>
	 	<input type="submit" value="SearchSpotify" />
 	</form>
 	</br>
 	

 
 </tr>
 <% } %>
 </table>
 
  <a href="logout">Sair do sistema</a>
</body>
</html>