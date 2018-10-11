<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="myPackage.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4/loose.dtd">

<html>
<head>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<title>Painel de Notas</title>
</head>

<body class="bg-dark text-light mt-3" style="overflow-x: hidden !important">
	<%DAO dao = new DAO();%>
  	<nav class="container-fluid navbar navbar-dark fixed-top bg-secondary">
  		<a class="navbar-brand">InsperNotes System</a>
  		<form action="login" method="POST" class="form-inline">
    	<button class="btn btn-sm btn-danger my-2 my-sm-0" type="submit">Sair</button>
  		</form>
	</nav>
  
  	<div class="row container" style="padding-top: 50px;">
    	<div class="col">
    		<h4 class="m-2 p-1">Olá, <%=request.getAttribute("Username")%>, este é o seu Painel de Notas</h4>
		<small>
			<ul>
				<li>Para criar uma nova nota basta digitar no modelo de nota em branco e salvar</li>
				<li>Para editar uma nota basta digitar no título ou corpo, escrever e depois salvar</li>
				<li>Para remover uma nota basta clicar em "Excluir"</li>
				<li>Viu só? Organizar sua vida nunca foi tão simples!</li>
			</ul>	
		</small>
		</div>   
	</div>
  
  	<div class="input-group mt-5">
		<div class="card mt-1 mb-2 ml-5 mr-1 p-1 text-dark" style="width: 17rem; min-height: 15rem;">
    		<div class="card-body">
       			<form action="crianota" method='POST'>
			    	<input type="number" name="user_id" value="<%=request.getAttribute("userId")%>" style="display: none">
			    	<input type="text" name="username" value="<%=request.getAttribute("Username")%>" style="display: none">
			    	<h5 class="card-title"><input type='text' name='title' placeholder="Titulo da Nota" style="width: 100%;" class="rounded border-0" autocomplete="off"></h5>
			    	<p class="card-text"><textarea rows='4' name='content' placeholder="Corpo da Nota" style="width: 100%; heigh: 100%; resize: none" class="rounded border-0" autocomplete="off"></textarea></p>
			    	<button type='submit' class="bg-light btn btn-outline-success btn-md btn-secondary rounded border border-success text-success m-1">Salvar</button>
			    </form>
    		</div>
		</div>

	<% List<Notas> notas = dao.getListaNotas((Integer)request.getAttribute("userId"));
	for (Notas nota : notas){
	%>
		<div class="card mt-1 mb-2 ml-1 mr-1 p-1 text-dark" style="width: 17rem; min-height: 15rem;">
  			<div class="card-body">
				<div class="input-group btn-group align-bottom" role="group">
					<form action='atualizanota' method='POST'>
						<input type="text" name="id" value="<%=nota.getId()%>" style="display: none">
    					<input type="text" name="username" value="<%=request.getAttribute("Username")%>" style="display: none">
    					<input type="text" name="user_id" value="<%=request.getAttribute("userId")%>" style="display: none">
			    		<h5 class="card-title"><input type='text' name='title' style="width: 100%;" class="rounded border-0" value="<%=nota.getTitle()%>" autocomplete="off"></h5>
    					<h5 class="card-text"><small><textarea rows='4' name='content' style="width: 100%; heigh: 100%; resize: none" class="rounded border-0" autocomplete="off"><%=nota.getContent()%></textarea></small></p>
						<button type='submit' class="bg-light btn btn-outline-success btn-md btn-secondary rounded border border-success text-success m-1">Salvar</button>
					</form>
					<input type="text" name="id" value="<%=nota.getId()%>" style="display: none">
    				<input type="text" name="username" value="<%=request.getAttribute("Username")%>" style="display: none">
    				<input type="text" name="user_id" value="<%=request.getAttribute("userId")%>" style="display: none">
					<button type='submit' formaction='removenota' class="bg-light btn btn-outline-danger btn-md btn-secondary rounded border border-danger text-danger m-1">Excluir</button></form>
 				</div>
  			</div>
		</div>
		<% } %>
  </div>

</body>
</html>