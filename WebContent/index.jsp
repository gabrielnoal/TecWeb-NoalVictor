<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="myPackage.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4/loose.dtd">

<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<title>InsperNotes System</title>
</head>

<body class="bg-dark text-light mt-3" style="overflow-x: hidden !important">
	<nav class="container-fluid navbar navbar-dark fixed-top bg-secondary">
		<a class="navbar-brand">InsperNotes System</a>
		<form action="login" method="POST" class="form-inline">
			<input class="form-control-sm mr-sm-2 border-0 rounded" type="text" placeholder="Nome de Usuario" autocomplete="off" name="username">
			<input class="form-control-sm mr-sm-2 border-0 rounded" type="password" placeholder="Senha" autocomplete="off" name="password">
			<button class="btn btn-sm btn-success my-2 my-sm-0" type="submit">Login</button>
		</form>
	</nav>

	<div class="container ">
		<div class="row" style="padding-top: 50px;">
			<div clas="col-7" style="padding-right: 200px;">
  				<h1 class="display-4">Bem vindo(a)</h1>
  				<h4>Este é o InsperNotes System. Aqui<br>
					você pode criar, editar e excluir notas <br>
					para facilitar sua organização cotidiana.</h4>		
			</div>
			<div class="col-5">
				<form action="criauser" method="POST" class="needs-validation" novalidate">
	  				<div class="form-row">
	    				<div class="col-md-6 mb-3">
	      					<label for="validationCustom01">Nome</label>
	      					<input type="text" class="form-control" id="validationCustom01" placeholder="José" name="name" autocomplete="off" required>
	      					<div class="valid-feedback">
	       						Aceito.
	      					</div>
	    				</div>
	    					<div class="col-md-6 mb-3">
	      						<label for="validationCustom02">Sobrenome</label>
	      						<input type="text" class="form-control" id="validationCustom02" placeholder="Silva" name="surname" autocomplete="off" required>
	    					</div>
	  				</div>
	
	   				<div class="form-row">  
	     				<div class="col-md-6 mb-3">
	      					<label for="validationCustomUsername">Nome de Usuario</label>
	      					<div class="input-group">
	        					<input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" name="username" autocomplete="off" required>
	        					<div class="invalid-feedback">
	 								Defina um nome de usuario
	        					</div>
	      					</div>
	    				</div>
	    
	    				<div class="col-sm-6 mb-3">
	      					<label for="validationCustom05">Senha</label>
	      					<input type="password" class="form-control" id="validationCustom05" minlength="6" name="password" autocomplete="off" required>
	      					<div class="invalid-feedback">
	        					Sua senha deve conter pelo menos 6 caracteres.
	      					</div>
	    				</div>
	  				</div>
	  
	    			<div class="form-row">
	    				<div class="col-md-3 mb-3">
	      					<label for="validationCustom03">Idade</label>
	      					<input type="number" class="form-control" id="validationCustom03" name="age" min="1" required>
	      					<div class="invalid-feedback">
	        					Adicione uma idade válda.
	      					</div>
	    				</div>
	    				<div class="col-md-9 mb-3">
	      					<label for="validationCustom04">E-mail</label>
	      					<input type="email" class="form-control" id="validationCustom04" placeholder="exemplo@exemplo.com" name="email" autocomplete="off" required>
	      					<div class="invalid-feedback">
	        					Por favor, insira um e-mail válido.
	      					</div>
	    				</div>
	   				</div>
	  				<button class="btn btn-md btn-success" type="submit">Cadastrar</button>
				</form>
			</div>
		</div>
		<img src="images/landpage_image.png" class="p-3 img-fluid" alt="Responsive image" style="display: block; margin-left: auto; margin-right: auto; width: 70%; heigh: 70%;">
	</div>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();
	</script>
</body>
</html>